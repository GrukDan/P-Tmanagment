package com.netcracker.edu.fapi.service.impl;

import com.netcracker.edu.fapi.models.Project;
import com.netcracker.edu.fapi.service.ProjectService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service("customProjectDetailsService")
public class ProjectServiceImpl implements ProjectService {

    @Value("${backend.server.url}")
    private String backendServerUrl;

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
        Project[] projectsResponse = restTemplate.getForObject(backendServerUrl + "/api/project", Project[].class);
        return projectsResponse == null ? Collections.emptyList() : Arrays.asList(projectsResponse);
    }

    @Override
    public Project save(Project project) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/project", project, Project.class).getBody();
    }
}
