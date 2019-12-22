package com.netcracker.edu.fapi.service.impl;

import com.netcracker.edu.fapi.models.Comment;
import com.netcracker.edu.fapi.models.User;
import com.netcracker.edu.fapi.models.ViewModels.CommentViewModel;
import com.netcracker.edu.fapi.models.ViewModels.UserViewModel;
import com.netcracker.edu.fapi.service.CommentService;
import com.netcracker.edu.fapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Autowired
    private UserService userService;

    @Override
    public Comment save(Comment comment) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/comment", comment, Comment.class).getBody();
    }

    @Override
    public List<CommentViewModel> getAllByTaskId(String size, String idTask) {
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("size", size);
        map.add("idTask", idTask);

        RestTemplate restTemplate = new RestTemplate();
        String url = UriComponentsBuilder.fromUriString(backendServerUrl + "/api/comments")
                .queryParams(map)
                .toUriString();
        Comment[] commentsResponse = restTemplate.getForObject(url, Comment[].class);
        List<CommentViewModel> commentViewModelList = new ArrayList();
        for(Comment comment:commentsResponse){
            CommentViewModel commentViewModel = new CommentViewModel(comment);
            UserViewModel user = userService.findById(comment.getIdUser());
            commentViewModel.setName(user.getName());
            commentViewModel.setSurname(user.getSurname());
            commentViewModelList.add(commentViewModel);
        }

        return commentsResponse == null ? Collections.emptyList() : commentViewModelList;
    }


    @Override
    public void deleteAllByTaskId(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + "/api/comment/" + id);
    }
}
