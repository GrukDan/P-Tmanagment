package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.User;
import com.netcracker.edu.backend.PaginationModels.UserPaginationModelResponse;

import java.util.List;

public interface UserService {
    UserPaginationModelResponse findAll(String parameter, int page, int size, int direction);
    User findByLogin(String login);
    User findByLoginAndPassword(String login,String password);
    User findById(Long idUser);
    User findByIdProject(Long idProject);
    User save(User user);
    User saveUserViewModel(User user);
    void delete(Long id);
    List<User> findAllByProjectId(Long id);
}
