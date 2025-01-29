package com.issuetracker.userinterface;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.issuetracker.exception.IssueTrackerException;
import com.issuetracker.model.Issue;
import com.issuetracker.model.IssueReport;
import com.issuetracker.model.IssueStatus;
import com.issuetracker.model.Unit;
import com.issuetracker.service.IssueService;
import com.issuetracker.service.IssueServiceImpl;

public class IssueTester
{
    private static IssueService issueService;
    private static PropertiesConfiguration propertiesConfiguration;

    private static final Log LOG = LogFactory.getLog(IssueTester.class);

    public static void main(String[] args) throws ConfigurationException
    {
	issueService = new IssueServiceImpl();
	propertiesConfiguration = new Configurations().properties("configuration.properties");
	
	 reportAnIssue();
	 updateStatus();
	 showIssues();
	 deleteIssues();
    }

    public static void reportAnIssue()
    {
	LOG.info("Mont Trance Inc. | Reporting An Issue");

	 Issue issue = new Issue("MTI-I-013-LS", "Booting up time is very high",
	 Unit.ADMINISTRATION,
	 LocalDate.now().minusDays(1), null, null,
	 IssueStatus.OPEN);
	
	 try
	 {
	 String issueId = issueService.reportAnIssue(issue);
	
	 LOG.info(propertiesConfiguration.getProperty("IssueTester.REPORT_ISSUE_SUCCESS")
	 + " " + issueId);
	 }
	 catch (IssueTrackerException issueTrackerException)
	 {
	 String exceptionMessage = issueTrackerException.getMessage();
	 if (exceptionMessage == null)
	 {
	 exceptionMessage = "IssueTester.GENERAL_EXCEPTION";
	 }
	
	 String errorMessage = (String)
	 propertiesConfiguration.getProperty(exceptionMessage);
	 if (errorMessage == null)
	 {
	 errorMessage = (String)
	 propertiesConfiguration.getProperty("IssueTester.GENERAL_EXCEPTION");
	 }
	
	 LOG.info(String.format("ERROR: %s", errorMessage));
	 }
    }

    public static void updateStatus()
    {
	LOG.info("Mont Trance Inc. | Updating Status");

	String issueId = "MTI-I-001-MS";
	 IssueStatus status = IssueStatus.RESOLVED;
	
	 try
	 {
	 Boolean isUpdateSuccess = issueService.updateStatus(issueId,
	 status);
	
	 if (Boolean.TRUE.equals(isUpdateSuccess))
	 {
	 LOG.info(propertiesConfiguration.getProperty("IssueTester.ISSUE_UPDATE_SUCCESS"));
	 }
	 }
	 catch (IssueTrackerException issueTrackerException)
	 {
	
	 String exceptionMessage = issueTrackerException.getMessage();
	 if (exceptionMessage == null)
	 {
	 exceptionMessage = "IssueTester.GENERAL_EXCEPTION";
	 }
	
	 String errorMessage = (String)
	 propertiesConfiguration.getProperty(exceptionMessage);
	 if (errorMessage == null)
	 {
	 errorMessage = (String)
	 propertiesConfiguration.getProperty("IssueTester.GENERAL_EXCEPTION");
	 }
	
	 LOG.info(String.format("ERROR: %s", errorMessage));
	 }
    }

    public static void showIssues()
    {
	LOG.info("Mont Trance Inc. | Showing Issues");

	Map<Character, Object> filterCriteria = new HashMap<>();
	 filterCriteria.put('S', IssueStatus.CLOSED);

	try
	{
	    List<IssueReport> issueReportList = issueService.showIssues(filterCriteria);

	    if (filterCriteria.containsKey('A'))
	    {
		LOG.info(String.format("Filter Criteria: Assignee Email > %s",
				       filterCriteria.get('A')));

		LOG.info("=".repeat(84));
		LOG.info(String.format("%s %-12s %s %-50s %s %-12s %s", "|",
				       "Issue ID", "|", "Issue Description",
				       "|", "Issue Status", "|"));
		LOG.info("=".repeat(84));

		 for (IssueReport issueReport : issueReportList)
		 {
		 LOG.info(String.format("%s %-12s %s %-50s %s %-12s %s", "|",
		 issueReport.getIssueId(), "|",
		 issueReport.getIssueDescription(),
		 "|", issueReport.getStatus(), "|"));
		 }
		LOG.info("=".repeat(84));
	    }
	    else
	    {
		LOG.info(String.format("Filter Criteria: Issue Status > %s",
				       filterCriteria.get('S')));

		LOG.info("=".repeat(87));
		LOG.info(String.format("%s %-12s %s %-50s %s %-15s %s", "|",
				       "Issue ID", "|", "Issue Description",
				       "|", "Assignee EMail", "|"));
		LOG.info("=".repeat(87));

		 for (IssueReport issueReport : issueReportList)
		 {
		 LOG.info(String.format("%s %-12s %s %-50s %s %-15s %s", "|",
		 issueReport.getIssueId(), "|",
		 issueReport.getIssueDescription(),
		 "|", issueReport.getAssigneeEmail(),
		 "|"));
		 }
		LOG.info("=".repeat(87));
	    }
	}
	catch (IssueTrackerException issueTrackerException)
	{
	    String exceptionMessage = issueTrackerException.getMessage();
	    if (exceptionMessage == null)
	    {
		exceptionMessage = "IssueTester.GENERAL_EXCEPTION";
	    }

	    String errorMessage = (String) propertiesConfiguration.getProperty(exceptionMessage);
	    if (errorMessage == null)
	    {
		errorMessage = (String) propertiesConfiguration.getProperty("IssueTester.GENERAL_EXCEPTION");
	    }

	    LOG.info(String.format("ERROR: %s", errorMessage));
	}
    }

    public static void deleteIssues()
    {
	LOG.info("Mont Trance Inc. | Deleting Issues");
	try
	{

	    List<Issue> deletedIssueList = issueService.deleteIssues();

	     if (!deletedIssueList.isEmpty())
	     {
	     LOG.info(deletedIssueList.size() + " "
	     +
	     propertiesConfiguration.getProperty("IssueTester.ISSUE_DELETE_SUCCESS"));
	     }

	    LOG.info("=".repeat(98));
	    LOG.info(String.format("%s %-12s %s %-50s %s %-15s %s %-8s %s", "|",
				   "Issue ID", "|", "Issue Description", "|",
				   "Assignee EMail", "|", "Status", "|"));
	    LOG.info("=".repeat(98));
	     for (Issue issue : deletedIssueList)
	     {
	     LOG.info(String.format("%s %-12s %s %-50s %s %-15s %s %-8s %s",
	     "|", issue.getIssueId(), "|",
	     issue.getIssueDescription(), "|",
	     issue.getAssigneeEmail(), "|",
	     issue.getStatus(), "|"));
	     }
	    LOG.info("=".repeat(98));
	}
	catch (IssueTrackerException issueTrackerException)
	{
	    String exceptionMessage = issueTrackerException.getMessage();
	    if (exceptionMessage == null)
	    {
		exceptionMessage = "IssueTester.GENERAL_EXCEPTION";
	    }

	    String errorMessage = (String) propertiesConfiguration.getProperty(exceptionMessage);
	    if (errorMessage == null)
	    {
		errorMessage = (String) propertiesConfiguration.getProperty("IssueTester.GENERAL_EXCEPTION");
	    }

	    LOG.info(String.format("ERROR: %s", errorMessage));
	}
    }
}