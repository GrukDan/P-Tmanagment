package com.netcracker.edu.fapi.controller;


import com.netcracker.edu.fapi.models.Project;
import com.netcracker.edu.fapi.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/project")
public class ProjectController {


    @Autowired
    private ProjectService projectService;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
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

    //    @RequestMapping(value="/signup", method = RequestMethod.POST, produces = "application/json")
    @RequestMapping(method = RequestMethod.POST)
    public Project saveProject(@RequestBody Project project) {
        return projectService.save(project);
    }
}
