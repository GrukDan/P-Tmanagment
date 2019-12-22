package com.netcracker.edu.fapi.controller;


import com.netcracker.edu.fapi.models.Project;
import com.netcracker.edu.fapi.models.ViewModels.ProjectViewModel;
import com.netcracker.edu.fapi.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class ProjectController {


    @Autowired
    private ProjectService projectService;

    @GetMapping("/projects")
    public List<Project> getAllProjects() {
        return projectService.findAll();
    }

    @GetMapping("/name/{name}")
    public Project getProjectByName(@PathVariable String name) {
        return projectService.findByName(name);
    }

    @GetMapping("/code/{code}")
    public Project getProjectByCode(@PathVariable String code) {
        return projectService.findByCode(code);
    }

    @RequestMapping(value = "/project", method = RequestMethod.POST)
    public Project saveProject(@RequestBody Project project) {
        return projectService.save(project);
    }

    @RequestMapping(value = "/project/{id}", method = RequestMethod.GET)
    public Project getProjectById(@PathVariable String id) {
        return projectService.findById(Long.valueOf(id));
    }

    @RequestMapping(value = "/project/view/model/{id}", method = RequestMethod.GET)
    public ProjectViewModel getProjectViewModelById(@PathVariable String id) {
        return projectService.findProjectViewModelById(Long.valueOf(id));
    }

    @RequestMapping(value = "/project/view/model", method = RequestMethod.POST)
    public Project saveProjectViewModel(@RequestBody ProjectViewModel projectViewModel) {
        return projectService.saveProjectViewModel(projectViewModel);
    }

    @RequestMapping(value = "/project", method = RequestMethod.DELETE)
    public void deleteProject(@RequestParam("idProject") String idProject) {
        projectService.deleteProject(idProject);
    }
}
