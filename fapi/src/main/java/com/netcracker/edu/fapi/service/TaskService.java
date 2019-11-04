package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.models.Task;

import java.util.List;

public interface TaskService {

    Task findByName(String name);
    Task findByCode(String code);
    List<Task> findAll();
    Task save(Task task);
}
