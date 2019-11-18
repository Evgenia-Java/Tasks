package com.evgenia.tasks.dao;

import com.evgenia.tasks.jdbc.TaskMapper;
import com.evgenia.tasks.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class TaskDAOImpl implements TaskDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Task> findTask(String assignee, LocalDate startDate, LocalDate endDate, String period){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String startDateString = startDate.format(formatter);
        String endDateString = endDate.format(formatter);
        Task task = new Task();
        task.autocomplete(period);

        String sql = "SELECT * FROM tasks";
        boolean useAnd = false;
        if (!assignee.isEmpty()){
            sql += (useAnd ? " AND" : " WHERE") + " assignee = '" + assignee + "'";
            useAnd = true;
        }

        if (!startDateString.isEmpty()){
            sql += (useAnd ? " AND" : " WHERE") + " start_date = '" + startDate + "'";
            useAnd = true;
        }

        if (!endDateString.isEmpty()){
            sql += (useAnd ? " AND" : " WHERE") + " end_date = '" + endDate + "'";
            useAnd = true;
        }

        return jdbcTemplate.query(sql, new TaskMapper());
    }

    @Override
    public void createTask(String summary, String assignee, LocalDate startDate, LocalDate endDate){
        String sql = "INSERT INTO tasks (summary, start_date, end_date, assignee) VALUES ('" +
                summary + "', '" + startDate + "', '" + endDate + "', '" + assignee + "')";
        jdbcTemplate.update(sql);
    }
}
