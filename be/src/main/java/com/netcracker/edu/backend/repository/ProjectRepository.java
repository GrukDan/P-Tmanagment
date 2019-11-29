package com.netcracker.edu.backend.repository;

import com.netcracker.edu.backend.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ProjectRepository extends JpaRepository<Project,Long> {
     Project findByIdProject(Long idProject);
}
