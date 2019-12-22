package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.Comment;
import com.netcracker.edu.backend.repository.CommentRepository;
import com.netcracker.edu.backend.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public Comment save(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public List<Comment> getByTaskId(int size, Long idTask) {
       return commentRepository.findAllByIdTask(idTask, PageRequest.of(0, size, Sort.by(Sort.Direction.DESC, "dateOfCreation"))).getContent();
    }

    @Override
    public void deleteAllByTaskId(Long idTask) {
        commentRepository.deleteByIdTask(idTask);
    }
}
