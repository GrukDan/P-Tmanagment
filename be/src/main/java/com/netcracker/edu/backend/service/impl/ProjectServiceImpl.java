package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.Project;
import com.netcracker.edu.backend.repository.ProjectRepository;
import com.netcracker.edu.backend.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public List<Project> findAll() {
        return (List<Project>) projectRepository.findAll();
    }

    @Override
    public Project findByCode(String code) {
        return null;
    }

    @Override
    public Project findById(Long id) {
        return projectRepository.findByIdProject(id);
    }


    @Override
    public Project save(Project project) {
        System.out.println(project.toString());
        return projectRepository.save(project);
    }

    @Override
    public void delete(String code) {

    }
}
