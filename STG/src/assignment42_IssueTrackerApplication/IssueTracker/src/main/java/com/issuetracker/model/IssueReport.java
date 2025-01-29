package com.issuetracker.model;

// Do Not Change Any Signature
public class IssueReport
{
    // Your Code Goes Here
    private String issueId;
    private String issueDescription;
    private String assigneeEmail;
    private IssueStatus status;

    public IssueReport(String issueId, String issueDescription, String assigneeEmail, IssueStatus status) {
        this.issueId = issueId;
        this.issueDescription = issueDescription;
        this.assigneeEmail = assigneeEmail;
        this.status = status;
    }

    public String getIssueId() {
        return issueId;
    }

    public void setIssueId(String issueId) {
        this.issueId = issueId;
    }

    public String getIssueDescription() {
        return issueDescription;
    }

    public void setIssueDescription(String issueDescription) {
        this.issueDescription = issueDescription;
    }

    public String getAssigneeEmail() {
        return assigneeEmail;
    }

    public void setAssigneeEmail(String assigneeEmail) {
        this.assigneeEmail = assigneeEmail;
    }

    public IssueStatus getStatus() {
        return status;
    }

    public void setStatus(IssueStatus status) {
        this.status = status;
    }
}