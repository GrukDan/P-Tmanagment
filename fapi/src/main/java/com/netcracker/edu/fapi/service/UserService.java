package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.models.User;
import com.netcracker.edu.fapi.models.UserViewModel;

import java.util.List;

public interface UserService {
    List<UserViewModel> findByIdProject(Long  idProject);
    UserViewModel findById(Long idUser);
    UserViewModel findByLogin(String login);
    UserViewModel findByLoginAndPassword(User user);
    List<UserViewModel> findAll();
    List<UserViewModel> findAllSortByName(int page,int size,int direction);
    User save(User user);
    void deleteById(Long idUser);
    UserViewModel saveUserViewModel(UserViewModel userViewModel);
}
