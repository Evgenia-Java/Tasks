package com.evgenia.tasks.model;

import java.util.Date;

public class Task {

    private int id;
    private String summary;
    private Date startDate;
    private Date endDate;
    private String assignee;

    public Task() {
    }

    public Task(int id, String summary, Date startDate, Date endDate, String assignee) {
        this.id = id;
        this.summary = summary;
        this.startDate = startDate;
        this.endDate = endDate;
        this.assignee = assignee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }
}
