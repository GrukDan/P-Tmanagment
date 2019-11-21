package com.netcracker.edu.backend.repository;

import com.netcracker.edu.backend.entity.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {
    Task findByIdTask(Long idTask);
    Task findByTaskCode(String taskCode);
    List<Task> findByExecutor(Long executor);
    List<Task> findByIdProject(Long idProject);
    List<Task> findAllByTaskName(String taskName);
}
