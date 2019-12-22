package com.netcracker.edu.backend.repository;

import com.netcracker.edu.backend.entity.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    Task findByIdTask(Long idTask);

    Task findByTaskCode(String taskCode);

    List<Task> findByExecutor(Long executor);

    List<Task> findByIdProject(Long idProjec);

    List<Task> findByIdProject(Long idProject, Sort sort);

    List<Task> findAllByTaskNameContainingIgnoreCase(String taskName);

    Page<Task> findAllByTaskNameContainingIgnoreCase(String taskName, Pageable pageable);

}
