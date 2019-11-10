package com.evgenia.tasks.controller;

import com.evgenia.tasks.dao.TaskDAO;
import com.evgenia.tasks.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TasksController {
    @Autowired
    private TaskDAO taskDAO;

//    @RequestMapping(value = "/tasks", method = RequestMethod.GET)
//    public String getTasks(Model model) {
//        List<Task> taskList = taskDAO.getAllTasks();
//        model.addAttribute("taskList", taskList);
//        return "tasks";
//    }


    @RequestMapping(value = "/tasks", method = RequestMethod.GET)
    @ResponseBody
    public String findTasks(@RequestParam("assignee") String assigne) {
//        Model model
//        List<Task> taskList = taskDAO.getAllTasks();
//        model.addAttribute("taskList", taskList);
        return "tasks";
    }

}
