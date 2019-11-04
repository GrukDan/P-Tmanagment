package com.netcracker.edu.fapi.controller;


import com.netcracker.edu.fapi.models.Task;
import com.netcracker.edu.fapi.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/task")
public class TaskController {


    @Autowired
    private TaskService taskService;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public List<Task> getAllUsers() {
        return taskService.findAll();
    }

    @GetMapping("/name/{name}")
    public Task getTaskByName(@PathVariable String name) {
        return taskService.findByName(name);
    }

    @GetMapping("/code/{code}")
    public Task getTaskByCode(@PathVariable String code) {
        return taskService.findByCode(code);
    }

    //    @RequestMapping(value="/signup", method = RequestMethod.POST, produces = "application/json")
    @RequestMapping(method = RequestMethod.POST)
    public Task saveUser(@RequestBody Task task) {
        return taskService.save(task);
    }
}
