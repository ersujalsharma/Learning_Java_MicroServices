package com.issuetracker.dao;

import java.util.List;

import com.issuetracker.model.Assignee;
import com.issuetracker.model.Unit;

public interface AssigneeDAO
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
    public abstract List<Assignee> fetchAssignees(Unit unit);

    /**
     * @params
     *         assigneeEmail - The assignee email id
     * 
     * @operation Fetches the assignee by the given email of the assignee
     * 
     * @returns
     *          Assignee - The fetched assignee object
     */
    public abstract Assignee getAssigneeByEmail(String assigneeEmail);
}