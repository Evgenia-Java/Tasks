package com.evgenia.tasks.dao;

import com.evgenia.tasks.model.Task;

import java.time.LocalDate;
import java.util.List;

public interface TaskDAO {

    List<Task> findTask(String assignee, LocalDate startDate, LocalDate endDate, String period);
    void createTask(String summary, String assignee, LocalDate startDate, LocalDate endDate);
}
