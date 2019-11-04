package com.netcracker.edu.fapi.service.impl;

import com.netcracker.edu.fapi.models.Task;
import com.netcracker.edu.fapi.service.TaskService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service("customTaskDetailsService")
public class TaskServiceImpl implements TaskService {

    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Override
    public Task findByName(String name) {
        RestTemplate restTemplate = new RestTemplate();
        Task task = restTemplate.getForObject(backendServerUrl + "/api/task/name/" + name, Task.class);
        return task;
    }

    @Override
    public Task findByCode(String code) {
        RestTemplate restTemplate = new RestTemplate();
        Task task = restTemplate.getForObject(backendServerUrl + "/api/task/code/" + code, Task.class);
        return task;
    }

    @Override
    public List<Task> findAll() {
        RestTemplate restTemplate = new RestTemplate();
        Task[] tasksResponse = restTemplate.getForObject(backendServerUrl + "/api/task", Task[].class);
        return tasksResponse == null ? Collections.emptyList() : Arrays.asList(tasksResponse);
    }

    @Override
    public Task save(Task task) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/task", task, Task.class).getBody();
    }
}
