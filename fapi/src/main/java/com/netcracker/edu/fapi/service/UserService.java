package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.models.User;
import java.util.List;

public interface UserService {
    List<User> findByIdProject(Long  idProject);
    User findById(Long idUser);
    User findByLogin(String login);
    List<User> findAll();
    User save(User user);
}
