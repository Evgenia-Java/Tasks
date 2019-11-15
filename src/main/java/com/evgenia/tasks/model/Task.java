package com.evgenia.tasks.model;

import java.time.*;

public class Task {

    private int id;
    private String summary;
    private LocalDate startDate;
    private LocalDate endDate;
    private String assignee;
    private String period;

    public Task() {
    }

    public Task(int id, String summary, LocalDate startDate, LocalDate endDate, String assignee) {
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

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public void autocomplete(String period){
        LocalDate today = LocalDate.now();
        int year = today.getYear();
        Month month = today.getMonth();
        DayOfWeek week = today.getDayOfWeek();
        switch (period){
            case ("Last Quarter"):
                LocalDate quarter1 = LocalDate.of(year, 1,1);
                LocalDate quarter2 = LocalDate.of(year, 4,1);
                LocalDate quarter3 = LocalDate.of(year, 7,1);
                LocalDate quarter4 = LocalDate.of(year, 10,1);
                if (today.isAfter(quarter1) && today.isBefore(quarter2)){
                    setStartDate(LocalDate.of(year, 1, 1));
                    setEndDate(LocalDate.of(year, 3,31));
                } else if(today.isAfter(quarter2) && today.isBefore(quarter3)){
                    setStartDate(LocalDate.of(year, 4, 1));
                    setEndDate(LocalDate.of(year, 6,30));
                } else if(today.isAfter(quarter3) && today.isBefore(quarter4)){
                    setStartDate(LocalDate.of(year, 7, 1));
                    setEndDate(LocalDate.of(year, 9,30));
                } else{
                    setStartDate(LocalDate.of(year, 10, 1));
                    setEndDate(LocalDate.of(year, 12,31));
                }
                break;
            case ("Last Month"):
                setStartDate(LocalDate.of(year, month, 1));
                setEndDate(LocalDate.of(year, month, 30));
                break;
            case ("Last Week"):
                break;
        }
    }
}
