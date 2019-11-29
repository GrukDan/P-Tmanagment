package com.netcracker.edu.backend.controller;


import com.netcracker.edu.backend.entity.Task;
import com.netcracker.edu.backend.service.TaskService;
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
    public List<Task> getAllTasks(){return taskService.findAll();}

    @RequestMapping(value = "/tasks/executor/{id}", method = RequestMethod.GET)
    public List<Task> getTaskByIdExecutor(@PathVariable(name = "id") Long id){return taskService.findByIdExecutor(id);}

    @RequestMapping(value = "/tasks/project/{id}", method = RequestMethod.GET)
    public List<Task> getAllTasksByIdProject(@PathVariable(name = "id") Long id){return taskService.findByIdProject(id);}

    @RequestMapping(value = "/tasks/name/{name}", method = RequestMethod.GET)
    public List<Task> getAllTasksName(@PathVariable(name = "name") String taskName){return taskService.findAllByName(taskName);}

    @RequestMapping(value="/task",method = RequestMethod.POST)
    public Task save(@RequestBody Task task){
        return taskService.save(task);
    }

    @RequestMapping(value="/task/{id}",method = RequestMethod.GET)
    public Task getById(@PathVariable(name = "id") Long id){
        return taskService.findById(id);
    }

    @RequestMapping(value="/task/delete/{id}",method = RequestMethod.DELETE)
    public void delete(@PathVariable(name = "id") Long id){
         taskService.deleteById(id);
    }

}
