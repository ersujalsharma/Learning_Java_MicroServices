package com.issuetracker.test;

import java.time.LocalDate;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Assertions;

import com.issuetracker.exception.IssueTrackerException;
import com.issuetracker.model.Issue;
import com.issuetracker.model.IssueStatus;
import com.issuetracker.model.Unit;
import com.issuetracker.service.IssueService;
import com.issuetracker.service.IssueServiceImpl;

// Do Not Change Any Signature
public class IssueServiceTest
{
    private IssueService issueService = new IssueServiceImpl();
    @Test
    public void reportAnIssueValidTest() throws IssueTrackerException
    {
	// Your Code Goes Here
	Issue issue = new Issue("MTI-I-013-HS", "Third menu item is missing", Unit.ADMINISTRATION, LocalDate.now().minusDays(11), null, null, IssueStatus.IN_PROGRESS);
	String val = issueService.reportAnIssue(issue);
	Assertions.assertEquals(issue.getIssueId(), val);
    }
    @Test
    public void reportAnIssueInvalidReportedDateTest()
    {
	// Your Code Goes Here
	Issue issue = new Issue("MTI-I-013-HS", "Third menu item is missing", Unit.ADMINISTRATION, LocalDate.now().plusDays(5), null, null, IssueStatus.IN_PROGRESS);
	Exception exception = Assertions.assertThrows(IssueTrackerException.class, ()->issueService.reportAnIssue(issue));
	Assertions.assertEquals(exception.getMessage(),"Validator.INVALID_REPORTED_DATE");
    }
    @Test
    public void reportAnIssueInvalidStatusTest()
    {
	// Your Code Goes Here
	Issue issue = new Issue("MTI-I-013-HS", "Third menu item is missing", Unit.ADMINISTRATION, LocalDate.now().minusDays(11), null, null, IssueStatus.CLOSED);
	Exception exception = Assertions.assertThrows(IssueTrackerException.class, ()->issueService.reportAnIssue(issue));
	Assertions.assertEquals(exception.getMessage(),"Validator.INVALID_STATUS");
    }
    @Test
    public void reportAnIssueDuplicateIssueIdTest()
    {
	// Your Code Goes Here
	Issue issue = new Issue("MTI-I-001-HS", "Third menu item is missing", Unit.ADMINISTRATION, LocalDate.now().minusDays(11), null, null, IssueStatus.IN_PROGRESS);
	Exception exception = Assertions.assertThrows(IssueTrackerException.class, ()->issueService.reportAnIssue(issue));
	Assertions.assertEquals(exception.getMessage(),"IssueService.DUPLICATE_ISSUE_ID");
    }
}