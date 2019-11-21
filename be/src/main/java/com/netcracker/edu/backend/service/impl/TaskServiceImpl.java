package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.Task;
import com.netcracker.edu.backend.repository.TaskRepository;
import com.netcracker.edu.backend.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
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
    public List<Task> findByIdUser(Long idUser) {
        return taskRepository.findByExecutor(idUser);
    }

    @Override
    public List<Task> findByIdProject(Long idProject) {
        return taskRepository.findByIdProject(idProject);
    }

    @Override
    public List<Task> findAllByName(String taskName) {
        return taskRepository.findAllByTaskName(taskName);
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
        return taskRepository.save(task);
    }

    @Override
    public void deleteById(Long idTask) {
        taskRepository.deleteById(idTask);
    }

}
