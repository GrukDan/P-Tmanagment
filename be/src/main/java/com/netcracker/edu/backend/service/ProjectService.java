package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.Project;

import java.util.List;

public interface ProjectService {

    List<Project> findAll();
    Project findByCode(String code);
    Project findById(Long id);
    Project save(Project project);
    void delete(String code);

}
