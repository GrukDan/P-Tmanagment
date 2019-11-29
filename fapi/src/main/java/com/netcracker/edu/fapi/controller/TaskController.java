package com.netcracker.edu.fapi.controller;


import com.netcracker.edu.fapi.models.Task;
import com.netcracker.edu.fapi.models.TaskViewModel;
import com.netcracker.edu.fapi.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/tasks")
    public List<Task> getAllTasks() {
        return taskService.findAll();
    }

    @RequestMapping(value = "/tasks/executor/{id}", method = RequestMethod.GET)
    public List<Task> getTasksByIdUser(@PathVariable String id) {
        return taskService.findByIdExecutor(Long.valueOf(id));
    }

    @RequestMapping(value = "/tasks/project/{id}", method = RequestMethod.GET)
    public List<Task> getTasksByIdProject(@PathVariable String id) {
        return taskService.findByIdProject(Long.valueOf(id));
    }

    @RequestMapping(value = "/tasks/name/{name}", method = RequestMethod.GET)
    public List<Task> getTasksByName(@PathVariable String name) {
        return taskService.findAllByName(name);
    }


    @RequestMapping(value = "/task/{id}", method = RequestMethod.GET)
    public Task getTaskById(@PathVariable String id) {
        return taskService.findById(Long.valueOf(id));
    }

    @RequestMapping(value = "/task", method = RequestMethod.POST)
    public Task saveTask(@RequestBody Task task) {
        return taskService.save(task);
    }

    @RequestMapping(value = "/task/view/model/{id}", method = RequestMethod.GET)
    public TaskViewModel getTaskViewModelById(@PathVariable String id) {
        return taskService.findTaskViewModelById(Long.valueOf(id));
    }

    @RequestMapping(value = "/task/view/model/",  method = RequestMethod.POST)
    public TaskViewModel saveTaskViewModelById(@RequestBody TaskViewModel taskViewModel) {
        return taskService.saveTaskViewModel(taskViewModel);
    }

    @RequestMapping(value = "/task/delete/{id}", method = RequestMethod.DELETE)
    public void deleteTaskById(@PathVariable String id) {
        taskService.deleteTask(Long.valueOf(id));
    }



    @RequestMapping(value = "/tasks/project/name/sort/priority{projectId}{count}", method = RequestMethod.GET)
    public void getTaskViewModelByIdProjectSortedByPriority(@RequestParam(value = "projectId") String projectId,@RequestParam(value = "count") String count) {
       // return taskService.findTaskViewModelById(Long.valueOf(id));
        System.out.println(projectId + "=============" + count);
    }
}
