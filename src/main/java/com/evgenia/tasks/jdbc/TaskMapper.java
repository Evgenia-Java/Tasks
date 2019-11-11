package com.evgenia.tasks.jdbc;

import com.evgenia.tasks.model.Task;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TaskMapper implements RowMapper<Task> {
    @Override
    public Task mapRow(ResultSet resultSet, int i) throws SQLException {
        Task task = new Task();
        task.setId(resultSet.getInt("id"));
        task.setSummary(resultSet.getString("summary"));
        task.setStartDate(resultSet.getDate("start_date"));
        task.setEndDate(resultSet.getDate("end_date"));
        task.setAssignee(resultSet.getString("assignee"));
        return task;
    }
}
