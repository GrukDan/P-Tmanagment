package com.netcracker.edu.backend.repository;

import com.netcracker.edu.backend.entity.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.net.ContentHandler;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    void deleteByIdTask(Long idTask);

    Page<Comment> findAllByIdTask(Long idTask, Pageable dateOfCreation);
}
