package com.issuetracker.service;

import java.util.List;

import com.issuetracker.dao.AssigneeDAO;
import com.issuetracker.dao.AssigneeDAOImpl;
import com.issuetracker.model.Assignee;
import com.issuetracker.model.Unit;

// Do Not Change Any Signature
public class AssigneeServiceImpl implements AssigneeService
{
    private AssigneeDAO assigneeDAO = new AssigneeDAOImpl();

    @Override
    public List<Assignee> fetchAssignee(Unit unit)
    {
	// Your Code Goes Here

        List<Assignee> list =  assigneeDAO.fetchAssignees(unit).stream().filter((t)->t.getNumberOfIssuesActive()<3).toList();
	    return list;
    }

    @Override
    public void updateActiveIssueCount(String assigneeEmail,
				       Character operation)
    {
	// Your Code Goes Here
        Assignee assignee = assigneeDAO.getAssigneeByEmail(assigneeEmail);
        if(operation.equals('I')){
            assignee.setNumberOfIssuesActive(assignee.getNumberOfIssuesActive()+1);
        }else{
            assignee.setNumberOfIssuesActive(assignee.getNumberOfIssuesActive()-1);
        }
    }
}