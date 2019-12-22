package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.PaginationModels.TaskPaginationModelResponse;
import com.netcracker.edu.backend.entity.Task;

import java.util.List;

public interface TaskService {

    List<Task> findAll();

    List<Task> findByIdExecutor(Long idUser);

    List<Task> findByIdProject(Long idProject);

    List<Task> findAllByName(String taskName);

    Task findById(Long idTask);

    Task findByCode(String code);

    Task save(Task task);

    void deleteById(Long idTask);

    List<Task> findTasksByIdProjectSorted(Long idProject, String parameter, int direction);

    TaskPaginationModelResponse findAllSorted(String parameter, int page, int size, boolean direction,String search);
}
