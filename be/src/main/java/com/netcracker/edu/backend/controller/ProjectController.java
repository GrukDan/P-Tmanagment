package com.netcracker.edu.backend.controller;


import com.netcracker.edu.backend.entity.Project;
import com.netcracker.edu.backend.service.ProjectService;
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
    public List<Project> getAllProjects(){
        System.out.println("get all");
        return projectService.findAll();
    }

//    @GetMapping
//    public Project getProjectByCode(@RequestParam String code){
//        return projectService.findByCode(code);
//    }

    @RequestMapping(value="/project",method = RequestMethod.POST)
    public Project save(@RequestBody Project project){
        System.out.println(project.toString());
        return projectService.save(project);
    }

    @RequestMapping(value="/project/{id}",method = RequestMethod.GET)
    public Project getProjectById(@PathVariable(name = "id") Long id){
        System.out.println(id);
        return projectService.findById(id);
    }

}
