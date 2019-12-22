package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.Comment;

import java.util.List;

public interface CommentService {

    Comment save(Comment comment);
    List<Comment> getByTaskId(int size, Long idTask);
    void deleteAllByTaskId(Long idTask);
}
