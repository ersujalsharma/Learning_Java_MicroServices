package com.issuetracker.service;

import java.util.List;
import java.util.Map;

import com.issuetracker.exception.IssueTrackerException;
import com.issuetracker.model.Issue;
import com.issuetracker.model.IssueReport;
import com.issuetracker.model.IssueStatus;

public interface IssueService
{
    /**
     * @params
     *         issue - The new issue to be reported
     * 
     * @operation Reports a new issue by
     *            * validating its details
     *            * fetch an assignee
     *            * persists the issue in the issueList
     * 
     * @returns
     *          String - The issue id
     */
    public abstract String reportAnIssue(Issue issue) throws IssueTrackerException;

    /**
     * @params
     *         issueId - The issue id
     *         status - The new status
     * 
     * @operation Updates the status of the given issue with the given status
     * 
     * @returns
     *          Boolean - Result of the status update
     */
    public abstract Boolean updateStatus(String issueId,
					 IssueStatus status) throws IssueTrackerException;

    /**
     * @params
     *         filterCriteria - A map where its
     *         key denotes an attribute of the issue object
     *         value contains the filter value
     * 
     * @operation Generates a report of issues based on the filter criteria
     * 
     * @returns
     *          List<IssueReport> - The list of filtered issue objects
     */
    public abstract List<IssueReport> showIssues(Map<Character, Object> filterCriteria) throws IssueTrackerException;

    /**
     * @operation Deletes the issue object which are resolved or closed,
     *            at least 14 days ago
     * 
     * @returns
     *          List<Issue> - The list of issues which had been deleted
     */
    public abstract List<Issue> deleteIssues() throws IssueTrackerException;

}