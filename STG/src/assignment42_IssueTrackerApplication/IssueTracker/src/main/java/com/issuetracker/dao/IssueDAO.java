package com.issuetracker.dao;

import java.util.List;

import com.issuetracker.model.Issue;
import com.issuetracker.model.IssueStatus;

public interface IssueDAO
{
    public abstract List<Issue> getIssueList();

    public abstract void setIssueList(List<Issue> issueList);

    /**
     * @params
     *         issue - The new issue to be added
     * 
     * @operation Stores a new issue in the issueList
     * 
     * @returns
     *          String - The issue id
     */
    public abstract String reportAnIssue(Issue issue);

    /**
     * @params
     *         issue - The issue to be updated
     *         status - The new status
     * 
     * @operation Updates the status of the given issue
     *            with the given status
     */
    public abstract void updateStatus(Issue issue, IssueStatus status);

    /**
     * @params
     *         issueId - The issue id to be fetched
     * 
     * @operation Fetches the issue object based on the given issue id
     * 
     * @returns
     *          Issue - The fetched issue object
     */
    public abstract Issue getIssueById(String issueId);
}