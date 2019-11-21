package com.netcracker.edu.backend.repository;

import com.netcracker.edu.backend.entity.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ProjectRepository extends CrudRepository<Project,Long> {
     Project findByIdProject(Long idProject);
}
