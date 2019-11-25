package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.User;
import com.netcracker.edu.backend.repository.UserRepository;

import com.netcracker.edu.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User findByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    @Override
    public User findByLoginAndPassword(String login, String password) {
        return userRepository.findByLoginAndPassword(login,password);
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
        System.out.println(user.toString());
        return userRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void delete(String login) {

    }

    @Override
    public List<User> findAllByProjectId(Long id) {
        return userRepository.findAllByAssignProject(id);
    }
}
