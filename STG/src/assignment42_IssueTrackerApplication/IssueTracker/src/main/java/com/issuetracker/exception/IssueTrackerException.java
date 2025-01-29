package com.issuetracker.exception;

public class IssueTrackerException extends Exception
{
    private static final long serialVersionUID = 9055345452217545316L;

    public IssueTrackerException(String message)
    {
	super(message);
    }
}