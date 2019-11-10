package com.evgenia.tasks.dao;

import com.evgenia.tasks.jdbc.TaskMapper;
import com.evgenia.tasks.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.ArrayList;
import java.util.List;

public class TaskDAOImpl implements TaskDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Task> getAllTasks() {
        List<Task> listAllTasks = new ArrayList<>();
//        Task t1 = new Task(1, "create project", LocalDate.of(2019,04,05),
//                LocalDate.of(2019,05,01), "John");
//        Task t2 = new Task(2, "create file", LocalDate.of(2019,04,06),
//                LocalDate.of(2019,04,07), "David");
//        listAllTasks.add(t1);
//        listAllTasks.add(t2);


        String SQL = "SELECT * FROM tasks";
        return jdbcTemplate.query(SQL, new TaskMapper());
    }

    public List<Task> findTask(String param){
        List<Task> taskListParam = new ArrayList<>();
        String SQL = "SELRCT * FROM tasks WHERE assignee = " + param;
        return jdbcTemplate.query(SQL, new TaskMapper());
    }
}
