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

    @RequestMapping(value = "/tasks", method = RequestMethod.GET)
    public String findTasks(Model model,
                            @RequestParam(name = "assignee", required = false, defaultValue = "") String assignee,
                            @RequestParam(name = "startDate", required = false, defaultValue = "") String startDate,
                            @RequestParam(name = "endDate", required = false, defaultValue = "") String endDate) {
        List<Task> taskList = taskDAO.findTask(assignee, startDate, endDate);
        model.addAttribute("taskList", taskList);
        model.addAttribute("assignee", assignee);
        model.addAttribute("startDate", startDate);
        model.addAttribute("endDate", endDate);
        return "tasks";
    }

    @RequestMapping(value = "/createTask", method = RequestMethod.GET)
    public String createTask(Model model){
        return "createTask";
    }

    @RequestMapping(value = "/addTask", method = RequestMethod.POST)
    public String addTask(Model model,
                          @RequestParam(name = "summary", defaultValue = "") String summary,
                          @RequestParam(name = "assignee", defaultValue = "") String assignee,
                          @RequestParam(name = "startDate",  defaultValue = "") String startDate,
                          @RequestParam(name = "endDate",  defaultValue = "") String endDate) {
        Task addTask = taskDAO.addTask(summary, assignee, startDate, endDate);
        return "redirect:/tasks";
    }

}
