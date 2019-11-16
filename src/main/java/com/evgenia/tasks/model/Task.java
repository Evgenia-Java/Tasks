package com.evgenia.tasks.model;

import java.time.*;
import java.time.temporal.IsoFields;
import java.time.temporal.WeekFields;
import java.util.Locale;

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

    public Task(String summary, LocalDate startDate, LocalDate endDate, String period) {
        this.summary = summary;
        this.startDate = startDate;
        this.endDate = endDate;
        this.period = period;
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
        int quarter = today.get(IsoFields.QUARTER_OF_YEAR);
        switch (period){
            case ("Last Quarter"):
                if (quarter == 1){
                    setStartDate(LocalDate.of(year-1, Month.OCTOBER, 1));
                    setEndDate(LocalDate.of(year-1, Month.DECEMBER,31));
                } else if(quarter == 2){
                    setStartDate(LocalDate.of(year, Month.JANUARY, 1));
                    setEndDate(LocalDate.of(year, Month.MARCH,31));
                } else if(quarter == 3){
                    setStartDate(LocalDate.of(year, Month.APRIL, 1));
                    setEndDate(LocalDate.of(year, Month.JUNE,30));
                } else{
                    setStartDate(LocalDate.of(year, Month.JULY, 1));
                    setEndDate(LocalDate.of(year, Month.SEPTEMBER,30));
                }
                break;
            case ("Last Month"):
                setStartDate(LocalDate.of(year, month.minus(1), 1));
                setEndDate(LocalDate.of(year, month.minus(1), 30));
                break;
            case ("Last Week"):
                setStartDate(today.minusWeeks(1).with(DayOfWeek.MONDAY));
                setEndDate(getStartDate().plusDays(6));
                break;
            case ("Current Quarter to Date"):
                if (quarter == 1){
                    setStartDate(LocalDate.of(year, Month.JANUARY, 1));
                } else if (quarter == 2){
                    setStartDate(LocalDate.of(year, Month.APRIL, 1));
                } else if (quarter == 3){
                    setStartDate(LocalDate.of(year, Month.JULY, 1));
                } else {
                    setStartDate(LocalDate.of(year, Month.OCTOBER, 1));
                }
                setEndDate(today);
                break;
            case ("Current Month to Date"):
                setStartDate(today.withDayOfMonth(1));
                setEndDate(today);
                break;
            case ("Current Week to Date"):
                setStartDate(LocalDate.from(WeekFields.of(Locale.getDefault()).getFirstDayOfWeek()));
                setEndDate(today);
                break;

        }
    }
}
