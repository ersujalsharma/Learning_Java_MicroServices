package com.issuetracker.service;

import java.util.List;

import com.issuetracker.model.Assignee;
import com.issuetracker.model.Unit;

public interface AssigneeService
{
    /**
     * @params
     *         unit - The assignee unit
     * 
     * @operation Fetches the assignees list for the given unit
     * 
     * @returns
     *          List<Assignee> - List of assignees fetched
     */
    public abstract List<Assignee> fetchAssignee(Unit unit);

    /**
     * @params
     *         assigneeEmail - The assignee email id
     *         operation - The operation code
     * 
     * @operation Updates the active issues count for the given assignee email,
     *            by incrementing or decrementing it based on the operation code
     * 
     */
    public abstract void updateActiveIssueCount(String assigneeEmail,
						Character operation);
}