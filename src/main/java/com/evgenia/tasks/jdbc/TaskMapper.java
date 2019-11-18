package com.evgenia.tasks.jdbc;

import com.evgenia.tasks.model.Task;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TaskMapper implements RowMapper<Task> {
    @Override
    public Task mapRow(ResultSet resultSet, int i) throws SQLException {
        Task task = new Task();
        task.setId(resultSet.getInt("id"));
        task.setSummary(resultSet.getString("summary"));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
//        String startDateString = resultSet.getString("start_date");
//        LocalDateTime localStartDateTime = LocalDateTime.parse(startDateString, formatter);
//        String endDateString = resultSet.getString("start_date");
//        LocalDateTime localEndDateTime = LocalDateTime.parse(endDateString, formatter);

        task.setStartDate(LocalDate.parse("start_date", formatter));
        task.setEndDate(LocalDate.parse("end_date", formatter));
        task.setAssignee(resultSet.getString("assignee"));
        return task;
    }
}
