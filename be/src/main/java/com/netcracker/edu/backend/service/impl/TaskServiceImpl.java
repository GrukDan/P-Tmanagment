package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.PaginationModels.TaskPaginationModelResponse;
import com.netcracker.edu.backend.entity.Task;
import com.netcracker.edu.backend.repository.TaskRepository;
import com.netcracker.edu.backend.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public List<Task> findAll() {
        return (List<Task>) taskRepository.findAll();
    }

    @Override
    public List<Task> findByIdExecutor(Long idUser) {
        return taskRepository.findByExecutor(idUser);
    }

    @Override
    public List<Task> findByIdProject(Long idProject) {
        return taskRepository.findByIdProject(idProject);
    }

    @Override
    public List<Task> findAllByName(String taskName) {
        return taskRepository.findAllByTaskNameContainingIgnoreCase(taskName);
    }

    @Override
    public Task findById(Long idTask) {
        return taskRepository.findByIdTask(idTask);
    }

    @Override
    public Task findByCode(String code) {
        return null;
    }

    @Override
    public Task save(Task task) {
        System.out.println(task.toString());
        return taskRepository.save(task);
    }

    @Override
    public void deleteById(Long idTask) {
        taskRepository.deleteById(idTask);
    }

    @Override
    public List<Task> findTasksByIdProjectSorted(Long idProject, String parameter, int direction) {
        if(direction == 1)
        return taskRepository.findByIdProject(idProject, new Sort(Sort.Direction.DESC,parameter));
        else return taskRepository.findByIdProject(idProject, new Sort(Sort.Direction.ASC,parameter));
    }

    @Override
    public TaskPaginationModelResponse findAllSorted(String parameter, int page, int size, boolean direction,String search) {
        Page<Task> taskPage;
        if (direction)
            taskPage = taskRepository.findAllByTaskNameContainingIgnoreCase(
                    search,
                    PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, parameter)));
        else taskPage = taskRepository.findAllByTaskNameContainingIgnoreCase(
                search,
                PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, parameter)));
        List<Task> taskList = taskPage.getContent();
        Task[] tasks = new Task[taskList.size()];
        tasks =  taskList.toArray(tasks);
        return new TaskPaginationModelResponse(taskPage.getTotalElements(), page, tasks);
    }

}
