package com.evgenia.tasks.controller;

import com.evgenia.tasks.dao.TaskDAO;
import com.evgenia.tasks.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
public class TasksController {
    @Autowired
    private TaskDAO taskDAO;

    @RequestMapping(value = "/tasks", method = RequestMethod.GET)
    public String findTasks(Model model,
                            @RequestParam(name = "assignee", required = false, defaultValue = "") String assignee,
                            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDate startDate,
                            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDate endDate,
//                            @RequestParam(name = "startDate", required = false, defaultValue = "") LocalDate startDate,
//                            @RequestParam(name = "endDate", required = false, defaultValue = "") LocalDate endDate,
                            @RequestParam(name = "period", required = false, defaultValue = "") String period) {
        List<Task> taskList = taskDAO.findTask(assignee, startDate, endDate, period);
        model.addAttribute("taskList", taskList);
        model.addAttribute("assignee", assignee);
        model.addAttribute("startDate", startDate);
        model.addAttribute("endDate", endDate);
        return "tasks";
    }

    @RequestMapping(value = "/createTask", method = RequestMethod.GET)
    public String createTask(Model model){
        return "/createTask";
    }

    @RequestMapping(value = "/createTask", method = RequestMethod.POST)
    public String createTask(Model model,
                          @RequestParam(name = "summary", required = false, defaultValue = "") String summary,
                          @RequestParam(name = "assignee", required = false, defaultValue = "") String assignee,
                          @RequestParam(name = "startDate",  required = false, defaultValue = "") LocalDate startDate,
                          @RequestParam(name = "endDate",  required = false, defaultValue = "") LocalDate endDate){
        taskDAO.createTask(summary, assignee, startDate, endDate);
        return "redirect:/tasks";
    }

//    protected Map referenceData(MultipartHttpServletRequest request) throws Exception{
//        Map referenceData = new HashMap();
//        Map<String,String> period = new LinkedHashMap<String, String>();
//        period.put("Last Quarter", "Last Quarter");
//        period.put("Last Month","Last Month");
//        period.put("Last Week","Last Week");
//        period.put("Current Quarter to Date","Current Quarter to Date");
//        period.put("Current Month to Date","Current Month to Date");
//        period.put("Current Week to Date","Current Week to Date");
//        referenceData.put("period", period);
//        return referenceData;
//    }


}
