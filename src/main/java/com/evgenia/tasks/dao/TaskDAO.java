package com.evgenia.tasks.dao;

import com.evgenia.tasks.model.Task;

import java.sql.SQLException;
import java.util.List;

public interface TaskDAO {

    List<Task> findTask(String assignee, String startDate, String endDate);
    void addTask(String summary, String assignee, String startDate, String endDate);
}
