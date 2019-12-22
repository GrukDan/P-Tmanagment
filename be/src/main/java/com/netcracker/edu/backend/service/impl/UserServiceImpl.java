package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.User;
import com.netcracker.edu.backend.PaginationModels.UserPaginationModelResponse;
import com.netcracker.edu.backend.repository.UserRepository;

import com.netcracker.edu.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserPaginationModelResponse findAll(String parameter, int page, int size, int direction) {
        Page<User> userPage;
        if (direction == 1)
            userPage = userRepository.findAll(PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, parameter)));
        else userPage = userRepository.findAll(PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, parameter)));
        List<User> userList = userPage.getContent();
        User[] users = new User[userList.size()];
        users = userList.toArray(users);
        return new UserPaginationModelResponse(userPage.getTotalElements(), page, users);
    }

    @Override
    public User findByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    @Override
    public User findByLoginAndPassword(String login, String password) {
        return userRepository.findByLoginAndPassword(login, password);
    }

    @Override
    public User findById(Long idUser) {
        return userRepository.findByIdUser(idUser);
    }

    @Override
    public User findByIdProject(Long idProject) {
        return null;
    }

    @Override
    public User save(User user) {
        User checkUser = userRepository.findByLoginAndPassword(user.getLogin(), user.getPassword());
        if (checkUser == null) return userRepository.save(user);
        else return null;
    }

    @Override
    public User saveUserViewModel(User user) {
        User userToUpdate = userRepository.getOne(user.getIdUser());
        userToUpdate.setName(user.getName());
        userToUpdate.setSurname(user.getSurname());
        userToUpdate.setEmail(user.getEmail());
        userToUpdate.setRole(user.getRole());
        userToUpdate.setAssignProject(user.getAssignProject());
        return userRepository.save(userToUpdate);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<User> findAllByProjectId(Long id) {
        return userRepository.findAllByAssignProject(id);
    }
}
