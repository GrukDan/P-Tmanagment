package com.netcracker.edu.fapi.controller;


import com.netcracker.edu.fapi.models.Comment;
import com.netcracker.edu.fapi.models.ViewModels.CommentViewModel;
import com.netcracker.edu.fapi.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @RequestMapping(value = "/comment",method = RequestMethod.POST)
    public Comment save(@RequestBody Comment comment){
        return commentService.save(comment);
    }

    @RequestMapping(value = "/comments",method = RequestMethod.GET)
    public List<CommentViewModel> getByTaskId(@RequestParam("size") String size,
                                              @RequestParam("idTask") String idTask){
        return commentService.getAllByTaskId(size,idTask);
    }

    @RequestMapping(value = "/comments",method = RequestMethod.DELETE)
    public void deleteAllByTaskId(@RequestParam("idTask") String idTask){
         commentService.deleteAllByTaskId(Long.valueOf(idTask));
    }
}
