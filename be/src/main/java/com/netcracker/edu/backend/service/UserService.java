package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.User;

import java.util.List;

public interface UserService {

    List<User> findAll();
    User findByLogin(String login);
    User findByLoginAndPassword(String login,String password);
    User findById(Long idUser);
    User findByIdProject(Long idProject);
    User save(User user);
    void delete(Long id);
    void delete(String login);
    List<User> findAllByProjectId(Long id);
}
