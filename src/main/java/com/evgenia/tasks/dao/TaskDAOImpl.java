package com.evgenia.tasks.dao;

import com.evgenia.tasks.jdbc.TaskMapper;
import com.evgenia.tasks.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;

public class TaskDAOImpl implements TaskDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Task> findTask(String assignee, String startDate, String endDate){
        String sql = "SELECT * FROM tasks";
        boolean useAnd = false;
        if (!assignee.isEmpty()){
            sql += (useAnd ? " AND" : " WHERE") + " assignee = '" + assignee + "'";
            useAnd = true;
        }

        if (!startDate.isEmpty()){
            sql += (useAnd ? " AND" : " WHERE") + " start_date = '" + startDate + "'";
            useAnd = true;
        }

        if (!endDate.isEmpty()){
            sql += (useAnd ? " AND" : " WHERE") + " end_date = '" + endDate + "'";
            useAnd = true;
        }

        return jdbcTemplate.query(sql, new TaskMapper());
    }

    public void addTask(String summary, String assignee, String startDate, String endDate){
        String sql = "INSERT INTO tasks VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, summary, assignee, startDate, endDate, new TaskMapper());
    }
}
