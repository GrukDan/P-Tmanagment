package com.netcracker.edu.backend.controller;


import com.netcracker.edu.backend.PaginationModels.TaskPaginationModelResponse;
import com.netcracker.edu.backend.entity.Task;
import com.netcracker.edu.backend.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @RequestMapping(value = "/tasks/executor/{id}", method = RequestMethod.GET)
    public List<Task> getTaskByIdExecutor(@PathVariable(name = "id") Long id){return taskService.findByIdExecutor(id);}

    @RequestMapping(value = "/tasks", method = RequestMethod.GET)
    public List<Task> getTaskByIdProjectSorted(@RequestParam("idProject") String idProject,
                                               @RequestParam("parameter") String parameter,
                                               @RequestParam("direction") int direction) {
        return taskService.findTasksByIdProjectSorted(Long.valueOf(idProject),parameter,direction);
    }

    @RequestMapping(value = "/tasks/pagination", method = RequestMethod.GET)
    public TaskPaginationModelResponse getAllTasksSorted(@RequestParam("parameter") String parameter,
                                                         @RequestParam("page") int page,
                                                         @RequestParam("size") int size,
                                                         @RequestParam("direction") boolean direction,
                                                         @RequestParam("search")String search) {
        return taskService.findAllSorted(parameter,page,size,direction,search);
    }

    @RequestMapping(value = "/tasks/project", method = RequestMethod.GET)
    public List<Task> getTaskByIdProject(@RequestParam("idProject") String idProject) {
        return taskService.findByIdProject(Long.valueOf(idProject));
    }

    @RequestMapping(value = "/tasks/name/{name}", method = RequestMethod.GET)
    public List<Task> getAllTasksName(@PathVariable(name = "name") String taskName){return taskService.findAllByName(taskName);}

    @RequestMapping(value="/task",method = RequestMethod.POST)
    public Task save(@RequestBody Task task){
        return taskService.save(task);
    }

    @RequestMapping(value="/task/{id}",method = RequestMethod.GET)
    public Task getById(@PathVariable(name = "id") Long id){
        return taskService.findById(id);
    }

    @RequestMapping(value="/task/delete/{id}",method = RequestMethod.DELETE)
    public void delete(@PathVariable(name = "id") Long id){
         taskService.deleteById(id);
    }

}
