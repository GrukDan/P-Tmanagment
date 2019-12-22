package com.netcracker.edu.fapi.service.impl;

import com.netcracker.edu.fapi.models.*;
import com.netcracker.edu.fapi.models.PaginationModels.TaskPaginationModel;
import com.netcracker.edu.fapi.models.PaginationModels.TaskPaginationModelResponse;
import com.netcracker.edu.fapi.models.PaginationModels.UserPaginationModelResponse;
import com.netcracker.edu.fapi.models.ViewModels.TaskViewModel;
import com.netcracker.edu.fapi.models.ViewModels.UserViewModel;
import com.netcracker.edu.fapi.service.ProjectService;
import com.netcracker.edu.fapi.service.TaskService;
import com.netcracker.edu.fapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Autowired
    private UserService userService;

    @Autowired
    private ProjectService projectService;


    @Override
    public TaskViewModel findTaskViewModelById(Long idTaskViewModel) {
        TaskViewModel taskViewModel = new TaskViewModel(findById(idTaskViewModel));

        if(taskViewModel.getExecutorId()!=null) {
            UserViewModel executor = userService.findById(taskViewModel.getExecutorId());
            taskViewModel.setExecutorName(executor.getName());
            taskViewModel.setExecutorSurname(executor.getSurname());
        }

        UserViewModel creator = userService.findById(taskViewModel.getTaskCreatorId());
        taskViewModel.setTaskCreatorName(creator.getName());
        taskViewModel.setTaskCreatorSurname(creator.getSurname());

        Project project = projectService.findById(taskViewModel.getIdProject());
        UserViewModel[] executors = userService.findByIdProject(project.getIdProject()).toArray(new UserViewModel[0]);
        taskViewModel.setExecutors(executors);
        return taskViewModel;
    }

    @Override
    public void deleteTask(Long idTask) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + "/api/task/delete/" + idTask);
    }

    @Override
    public Task findById(Long idTask) {
        RestTemplate restTemplate = new RestTemplate();
        Task task = restTemplate.getForObject(backendServerUrl + "/api/task/" + idTask, Task.class);
        return task;
    }


    @Override
    public List<Task> findAll() {
        RestTemplate restTemplate = new RestTemplate();
        Task[] tasksResponse = restTemplate.getForObject(backendServerUrl + "/api/tasks", Task[].class);
        return tasksResponse == null ? Collections.emptyList() : Arrays.asList(tasksResponse);
    }

    @Override
    public List<Task> findByIdExecutor(Long idUser) {
        RestTemplate restTemplate = new RestTemplate();
        Task[] tasksResponse = restTemplate.getForObject(backendServerUrl + "/api/tasks/executor/" + idUser, Task[].class);
        return tasksResponse == null ? Collections.emptyList() : Arrays.asList(tasksResponse);
    }

    @Override
    public List<Task> findByIdProject(Long idProject) {
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("idProject", idProject.toString());
        String url = UriComponentsBuilder.fromUriString(backendServerUrl + "/api/tasks/project")
                .queryParams(map)
                .toUriString();

        RestTemplate restTemplate = new RestTemplate();
        Task[] tasksResponse = restTemplate.getForObject(url, Task[].class);
        return tasksResponse == null ? Collections.emptyList() : Arrays.asList(tasksResponse);
    }

    @Override
    public List<Task> findTaskByIdProjectSorted(String idProject, String parameter, String direction) {
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("idProject", idProject);
        map.add("parameter", parameter);
        map.add("direction", direction);

        RestTemplate restTemplate = new RestTemplate();
        String url = UriComponentsBuilder.fromUriString(backendServerUrl + "/api/tasks")
                .queryParams(map)
                .toUriString();
        Task[] tasks = restTemplate.getForObject(url, Task[].class);
        return tasks == null ? Collections.emptyList() : Arrays.asList(tasks);
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
        double readnesDegree = 0;
        int countOfTask = 1;
        List<Task> taskArrayList = findByIdProject(task.getIdProject());
        readnesDegree += task.getReadnesDegree();
        for (Task value : taskArrayList) {
            if (task.getIdTask() != null && task.getIdTask().equals(value.getIdTask())) continue;
            readnesDegree += value.getReadnesDegree();
            countOfTask++;
        }
        Project project = projectService.findById(task.getIdProject());
        project.setReadinessDegree(readnesDegree / countOfTask);
        projectService.save(project);
        return restTemplate.postForEntity(backendServerUrl + "/api/task", task, Task.class).getBody();
    }

    @Override
    public TaskViewModel saveTaskViewModel(TaskViewModel taskViewModel) {
        double readnesDegree = 0;
        int countOfTask = 1;
        List<Task> taskArrayList = findByIdProject(taskViewModel.getIdProject());
        readnesDegree += taskViewModel.getReadnesDegree();
        for (Task value : taskArrayList) {
            if (value.getIdTask().equals(taskViewModel.getIdTask())) continue;
            readnesDegree += value.getReadnesDegree();
            countOfTask++;
        }
        Project project = projectService.findById(taskViewModel.getIdProject());
        project.setReadinessDegree(readnesDegree / countOfTask);
        projectService.save(project);

        return new TaskViewModel(save(taskViewModel.getTask()));
    }

    @Override
    public TaskPaginationModel findAllSorted(String parameter, String page, String size, String direction,String search) {
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("parameter", parameter);
        map.add("page", page);
        map.add("size", size);
        map.add("direction", direction);
        map.add("search",search);

        RestTemplate restTemplate = new RestTemplate();
        String url = UriComponentsBuilder.fromUriString(backendServerUrl + "/api/tasks/pagination")
                .queryParams(map)
                .toUriString();
        TaskPaginationModelResponse taskPaginationModelResponse = restTemplate.getForObject(url, TaskPaginationModelResponse.class);

        UserViewModel user;
        TaskViewModel[] taskViewModels = new TaskViewModel[taskPaginationModelResponse.getTasksOnPage().length];
        for (int i = 0; i < taskViewModels.length; i++) {
            if(taskPaginationModelResponse.getTasksOnPage()[i].getExecutor()!=null) {
                user = userService.findById(taskPaginationModelResponse.getTasksOnPage()[i].getExecutor());
                taskViewModels[i] = new TaskViewModel(taskPaginationModelResponse.getTasksOnPage()[i]);
                taskViewModels[i].setExecutorName(user.getName());
                taskViewModels[i].setExecutorSurname(user.getSurname());
            }
        }
        TaskPaginationModel taskPaginationModel = new TaskPaginationModel(
                taskPaginationModelResponse.getPagesCount(),
                taskPaginationModelResponse.getPageNumber(),
                Arrays.asList(taskViewModels));
        return taskPaginationModel;
    }
}
