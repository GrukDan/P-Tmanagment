package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.models.Task;
import com.netcracker.edu.fapi.models.TaskViewModel;

import java.util.List;

public interface TaskService {
    TaskViewModel findTaskViewModelById(Long  idTaskViewModel);

    void deleteTask(Long  idTask);

    Task findById(Long  idTask);

    Task findByName(String name);

    Task findByCode(String code);

    List<Task> findAll();

    List<Task> findByIdUser(Long  idUser);

    List<Task> findByIdProject(Long  idProject);

    List<Task> findAllByName(String  taskName);

    Task save(Task task);
    TaskViewModel saveTaskViewModel(TaskViewModel taskViewModel);
}
