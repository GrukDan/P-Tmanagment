package com.netcracker.edu.fapi.controller;


import com.netcracker.edu.fapi.models.PaginationModels.TaskPaginationModel;
import com.netcracker.edu.fapi.models.Task;
import com.netcracker.edu.fapi.models.ViewModels.TaskViewModel;
import com.netcracker.edu.fapi.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class TaskController {

    @Autowired
    private TaskService taskService;

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

    @RequestMapping(value = "/tasks", method = RequestMethod.GET)
    public List<Task> getTaskByIdProjectSorted(@RequestParam("idProject") String idProject,
                                               @RequestParam("parameter") String parameter,
                                               @RequestParam("direction") String direction) {
        return taskService.findTaskByIdProjectSorted(idProject,parameter,direction);
    }

    @RequestMapping(value = "/tasks/pagination", method = RequestMethod.GET)
    public TaskPaginationModel getTasksSorted(@RequestParam("parameter") String parameter,
                                              @RequestParam("page") String page,
                                              @RequestParam("size") String size,
                                              @RequestParam("direction") String direction,
                                              @RequestParam("search") String search) {
        return taskService.findAllSorted(parameter,page,size,direction,search);
    }
}
