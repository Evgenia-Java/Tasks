package com.evgenia.tasks.jdbc;

import com.evgenia.tasks.model.Task;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class TaskMapper implements RowMapper<Task> {
    @Override
    public Task mapRow(ResultSet resultSet, int i) throws SQLException {
        Task task = new Task();
        task.setId(resultSet.getInt("id"));
        task.setSummary(resultSet.getString("summary"));
        task.setStartDate(LocalDate.parse(("start_date")));
        task.setEndDate(LocalDate.parse(("end_date")));
        task.setAssignee(resultSet.getString("assignee"));
        return task;
    }
}
