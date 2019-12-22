package com.netcracker.edu.backend.controller;


import com.netcracker.edu.backend.entity.Comment;
import com.netcracker.edu.backend.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @RequestMapping(value = "/comment", method = RequestMethod.POST)
    public Comment save(@RequestBody Comment comment) {
        return commentService.save(comment);
    }

    @RequestMapping(value = "/comments", method = RequestMethod.GET)
    public List<Comment> getAllByTaskId(@RequestParam("size") int size,
                                        @RequestParam("idTask") Long idTask) {
        return commentService.getByTaskId(size, idTask);
    }

    @RequestMapping(value = "/comments", method = RequestMethod.DELETE)
    public void deleteAllByTaskId(@PathVariable("idTask") Long idTask) {
        commentService.deleteAllByTaskId(idTask);
    }

}
