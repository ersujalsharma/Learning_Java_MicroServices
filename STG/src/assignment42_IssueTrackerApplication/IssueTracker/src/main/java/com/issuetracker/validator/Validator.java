package com.issuetracker.validator;

import java.time.LocalDate;

import com.issuetracker.exception.IssueTrackerException;
import com.issuetracker.model.Issue;
import com.issuetracker.model.IssueStatus;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

// Do Not Change Any Signature
public class Validator
{
    private static final Log LOGGER = LogFactory.getLog(Validator.class);
    public void validate(Issue issue) throws IssueTrackerException
    {
	// Your Code Goes Here
        try {
            if(!isValidIssueId(issue.getIssueId())){
                throw new IssueTrackerException("Validator.INVALID_ISSUE_ID");
            }
            if(!isValidIssueDescription(issue.getIssueDescription())){
                throw new IssueTrackerException("Validator.INVALID_ISSUE_DESCRIPTION");
            }
            if(!isValidReportedOn(issue.getReportedOn())){
                throw new IssueTrackerException("Validator.INVALID_REPORTED_DATE");
            }
            if(!isValidStatus(issue.getStatus())){
                throw new IssueTrackerException("Validator.INVALID_STATUS");
            }
        } catch (IssueTrackerException e) {
            LOGGER.error(e.getMessage());
            throw e;
        }
    }

    public Boolean isValidIssueId(String issueId)
    {
	// Your Code Goes Here

	return issueId.matches("MTI-I-(?!000)\\d{3}-(LS|MS|HS)");
    }

    public Boolean isValidIssueDescription(String issueDescription)
    {
	// Your Code Goes Here

	return issueDescription.matches("[A-Za-z]+( [A-Za-z]+){0,49}");
    }

    public Boolean isValidReportedOn(LocalDate reportedOn)
    {
	// Your Code Goes Here

	return !reportedOn.isAfter(LocalDate.now());
    }

    public Boolean isValidStatus(IssueStatus status)
    {
	// Your Code Goes Here

	return status.equals(IssueStatus.OPEN) || status.equals(IssueStatus.IN_PROGRESS);
    }
}