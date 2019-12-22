package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.models.Comment;
import com.netcracker.edu.fapi.models.ViewModels.CommentViewModel;

import java.util.List;

public interface CommentService {

    Comment save(Comment comment);
    List<CommentViewModel> getAllByTaskId(String size, String idTask);
    void deleteAllByTaskId(Long id);

}
