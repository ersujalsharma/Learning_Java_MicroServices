package com.issuetracker.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;

import com.issuetracker.dao.IssueDAO;
import com.issuetracker.dao.IssueDAOImpl;
import com.issuetracker.exception.IssueTrackerException;
import com.issuetracker.model.Assignee;
import com.issuetracker.model.Issue;
import com.issuetracker.model.IssueReport;
import com.issuetracker.model.IssueStatus;
import com.issuetracker.validator.Validator;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

// Do Not Change Any Signature
public class IssueServiceImpl implements IssueService
{
    private AssigneeService assigneeService = new AssigneeServiceImpl();
    private IssueDAO issueDAO = new IssueDAOImpl();
    private Validator validator = new Validator();
    private static final Log LOGGER = LogFactory.getLog(Validator.class);
    @Override
    public String reportAnIssue(Issue issue) throws IssueTrackerException
    {
	// Your Code Goes Here
        try {
            validator.validate(issue);
            List<Assignee> list = assigneeService.fetchAssignee(issue.getIssueUnit());
            if (!list.isEmpty()) {
                Assignee first = list.get(0);
                issue.setAssigneeEmail(first.getAssigneeEmail());
                assigneeService.updateActiveIssueCount(issue.getAssigneeEmail(), 'I');
            }
            String issueId = issueDAO.reportAnIssue(issue);
            if(issueId==null) throw new IssueTrackerException("IssueService.DUPLICATE_ISSUE_ID");
            return issueId;
        }
        catch (IssueTrackerException e) {
            LOGGER.error(e.getMessage());
            throw e;
        }
    }

    @Override
    public Boolean updateStatus(String issueId,
				IssueStatus status) throws IssueTrackerException
    {
	// Your Code Goes Here
        try {
            Issue issue = issueDAO.getIssueById(issueId);
            if(issue == null) throw new IssueTrackerException("IssueService.ISSUE_NOT_FOUND");
            if(status.equals(issue.getStatus())){
                throw new IssueTrackerException("IssueService.NO_STATUS_CHANGE");
            }
            if (status.equals(IssueStatus.RECALLED )) {
                throw new IssueTrackerException("IssueService.INCOMPATIBLE_STATUS");
            }
            issueDAO.updateStatus(issue,status);
            if(issue.getStatus() != IssueStatus.OPEN || issue.getStatus() != IssueStatus.IN_PROGRESS){
                assigneeService.updateActiveIssueCount(issue.getAssigneeEmail(),'D');
            }
        } catch (IssueTrackerException e) {
            LOGGER.error(e.getMessage());
            throw e;
        }
        return true;
    }

    @Override
    public List<IssueReport> showIssues(Map<Character, Object> filterCriteria) throws IssueTrackerException
    {
	// Your Code Goes Here
        try {
            List<Issue> list = issueDAO.getIssueList();
            for(Character character : filterCriteria.keySet()){
                if(character.equals('S')){
                    IssueStatus status = (IssueStatus) filterCriteria.get(character);
                    list.removeIf(issue -> !issue.getStatus().equals(status));
                }
                if(character.equals('A')){
                    String assigneeEmail = (String) filterCriteria.get(character);
                    list.removeIf(issue -> !issue.getAssigneeEmail().equals(assigneeEmail));
                }
            }
            if(list.isEmpty()){
                throw new IssueTrackerException("IssueService.NO_ISSUES_FOUND");
            }
            else{
                List<IssueReport> issueReports = list.stream().map(issue -> new IssueReport(issue.getIssueId(),issue.getIssueDescription(),issue.getAssigneeEmail(),issue.getStatus())).toList();
                return issueReports;
            }
        } catch (IssueTrackerException e) {
            LOGGER.error(e.getMessage());
            throw e;
        }
    }

    @Override
    public List<Issue> deleteIssues() throws IssueTrackerException
    {
	// Your Code Goes Here
        try {
            List<Issue> list = issueDAO.getIssueList();
            List<Issue> newList = list.stream().filter(issue -> issue.getStatus().equals(IssueStatus.CLOSED) || issue.getStatus().equals(IssueStatus.RESOLVED)).filter(issue -> ChronoUnit.DAYS.between(issue.getReportedOn(),LocalDate.now())<14).toList();
            if(newList.isEmpty()){
                throw new IssueTrackerException("IssueService.NO_ISSUES_DELETED");
            }
            list = list.stream().filter(issue -> !newList.contains(issue)).toList();
            return list;
        } catch (IssueTrackerException e) {
            LOGGER.error(e.getMessage());
            throw e;
        }
    }

    public Issue getIssueById(String issueId) throws IssueTrackerException
    {
	return issueDAO.getIssueById(issueId);
    }
}