package com.netcracker.edu.fapi.service.impl;

import com.netcracker.edu.fapi.models.*;
import com.netcracker.edu.fapi.service.ProjectService;
import com.netcracker.edu.fapi.service.TaskService;
import com.netcracker.edu.fapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private UserService userService;

    @Autowired
    private ProjectService projectService;


    @Override
    public TaskViewModel findTaskViewModelById(Long  idTaskViewModel) {
        TaskViewModel taskViewModel = new TaskViewModel(findById(idTaskViewModel));

        UserViewModel executor = userService.findById(taskViewModel.getExecutorId());
        taskViewModel.setExecutorName(executor.getName());
        taskViewModel.setExecutorSurname(executor.getSurname());

        UserViewModel creator = userService.findById(taskViewModel.getTaskCreatorId());
        taskViewModel.setTaskCreatorName(creator.getName());
        taskViewModel.setTaskCreatorSurname(creator.getSurname());

        Project project = projectService.findById(taskViewModel.getIdProject());
        UserViewModel[] executors = userService.findByIdProject(project.getIdProject()).toArray(new UserViewModel[0]);
        taskViewModel.setExecutors(executors);
        return taskViewModel;
    }

    @Override
    public void deleteTask(Long  idTask) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + "/api/task/delete/" + idTask);
    }

    @Override
    public Task findById(Long  idTask) {
        RestTemplate restTemplate = new RestTemplate();
        Task task = restTemplate.getForObject(backendServerUrl + "/api/task/" + idTask, Task.class);
        return task;
    }

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
        Task[] tasksResponse = restTemplate.getForObject(backendServerUrl + "/api/tasks", Task[].class);
        return tasksResponse == null ? Collections.emptyList() : Arrays.asList(tasksResponse);
    }

    @Override
    public List<Task> findByIdUser(Long  idUser) {
        RestTemplate restTemplate = new RestTemplate();
        Task[] tasksResponse = restTemplate.getForObject(backendServerUrl + "/api/tasks/user/" + idUser, Task[].class);
        return tasksResponse == null ? Collections.emptyList() : Arrays.asList(tasksResponse);
    }

    @Override
    public List<Task> findByIdProject(Long  idProject) {
        RestTemplate restTemplate = new RestTemplate();
        Task[] tasksResponse = restTemplate.getForObject(backendServerUrl + "/api/tasks/project/" + idProject, Task[].class);
        return tasksResponse == null ? Collections.emptyList() : Arrays.asList(tasksResponse);
    }

    @Override
    public List<Task> findAllByName(String taskName) {
        RestTemplate restTemplate = new RestTemplate();
        Task[] tasksResponse = restTemplate.getForObject(backendServerUrl + "/api/tasks/name/" + taskName, Task[].class);
        return tasksResponse == null ? Collections.emptyList() : Arrays.asList(tasksResponse);
    }

    @Override
    public Task save(Task task) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/task", task, Task.class).getBody();
    }

    @Override
    public TaskViewModel saveTaskViewModel(TaskViewModel taskViewModel) {
        save(taskViewModel.getTask());
        return taskViewModel;
    }
}
