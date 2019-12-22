package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.models.Project;
import com.netcracker.edu.fapi.models.ViewModels.ProjectViewModel;

import java.util.List;

public interface ProjectService {
    void deleteProject(String idProject);
    Project findById(Long  id);
    ProjectViewModel findProjectViewModelById(Long  id);
    Project saveProjectViewModel(ProjectViewModel  projectViewModel);
    Project findByName(String name);
    Project findByCode(String code);
    List<Project> findAll();
    Project save(Project project);
}
