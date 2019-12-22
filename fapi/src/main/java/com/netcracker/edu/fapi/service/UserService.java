package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.models.PaginationModels.UserPaginationModel;
import com.netcracker.edu.fapi.models.User;
import com.netcracker.edu.fapi.models.ViewModels.UserViewModel;

import java.util.List;

public interface UserService {
    List<UserViewModel> findByIdProject(Long idProject);

    UserViewModel findById(Long idUser);

    User findByLoginAndPassword(String login, String password);

    UserPaginationModel findAllSort(String parameter, String page, String size, String direction);

    User save(User user);

    void deleteById(Long idUser);

    UserViewModel saveUserViewModel(UserViewModel userViewModel);
}
