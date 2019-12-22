package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.models.PaginationModels.TaskPaginationModel;
import com.netcracker.edu.fapi.models.Task;
import com.netcracker.edu.fapi.models.ViewModels.TaskViewModel;

import java.util.List;

public interface TaskService {
    TaskViewModel findTaskViewModelById(Long idTaskViewModel);

    void deleteTask(Long idTask);

    Task findById(Long idTask);

    List<Task> findAll();

    List<Task> findByIdExecutor(Long idUser);

    List<Task> findByIdProject(Long idProject);

    List<Task> findTaskByIdProjectSorted(String idProject, String parameter, String direction);

    List<Task> findAllByName(String taskName);

    Task save(Task task);

    TaskViewModel saveTaskViewModel(TaskViewModel taskViewModel);

    TaskPaginationModel findAllSorted(String parameter, String page, String size, String direction,String search);
}
