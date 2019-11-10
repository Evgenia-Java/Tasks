package com.evgenia.tasks.dao;

import com.evgenia.tasks.model.Task;

import java.util.List;

public interface TaskDAO {

    List<Task> findTask(String assignee, String startDate, String endDate);
    Task addTask(String summary, String assignee, String startDate, String endDate);
}
