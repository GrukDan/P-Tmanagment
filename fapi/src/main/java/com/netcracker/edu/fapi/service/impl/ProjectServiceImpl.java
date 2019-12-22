package com.netcracker.edu.fapi.service.impl;

import com.netcracker.edu.fapi.models.*;
import com.netcracker.edu.fapi.models.ViewModels.ProjectViewModel;
import com.netcracker.edu.fapi.models.ViewModels.UserViewModel;
import com.netcracker.edu.fapi.service.ProjectService;
import com.netcracker.edu.fapi.service.TaskService;
import com.netcracker.edu.fapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Autowired
    private UserService userService;

    @Autowired
    private TaskService taskService;

    @Override
    public void deleteProject(String idProject) {
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("idProject", idProject);

        RestTemplate restTemplate = new RestTemplate();
        String url = UriComponentsBuilder.fromUriString(backendServerUrl + "/api/project")
                .queryParams(map)
                .toUriString();
         restTemplate.delete(url);
    }

    @Override
    public Project findById(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        Project project = restTemplate.getForObject(backendServerUrl + "/api/project/" + id, Project.class);
        return project;
    }

    @Override
    public ProjectViewModel findProjectViewModelById(Long id) {
        ProjectViewModel projectViewModel = new ProjectViewModel(findById(id));

        UserViewModel user = userService.findById(projectViewModel.getProjectCreator());
        projectViewModel.setProjectCreatorName(user.getName());
        projectViewModel.setProjectCreatorSurname(user.getSurname());

        return projectViewModel;
    }

    @Override
    public Project saveProjectViewModel(ProjectViewModel projectViewModel) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/project", projectViewModel.getProject(), Project.class).getBody();
    }

    @Override
    public Project findByName(String name) {
        RestTemplate restTemplate = new RestTemplate();
        Project project = restTemplate.getForObject(backendServerUrl + "/api/project/name/" + name, Project.class);
        return project;
    }

    @Override
    public Project findByCode(String code) {
        RestTemplate restTemplate = new RestTemplate();
        Project project = restTemplate.getForObject(backendServerUrl + "/api/project/code/" + code, Project.class);
        return project;
    }

    @Override
    public List<Project> findAll() {
        RestTemplate restTemplate = new RestTemplate();
        Project[] projectsResponse = restTemplate.getForObject(backendServerUrl + "/api/projects", Project[].class);
        return projectsResponse == null ? Collections.emptyList() : Arrays.asList(projectsResponse);
    }

    @Override
    public Project save(Project project) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/project", project, Project.class).getBody();
    }
}
