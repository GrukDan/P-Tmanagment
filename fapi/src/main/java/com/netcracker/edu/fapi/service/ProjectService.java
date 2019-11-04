package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.models.Project;

import java.util.List;

public interface ProjectService {

    Project findByName(String name);
    Project findByCode(String code);
    List<Project> findAll();
    Project save(Project project);
}
