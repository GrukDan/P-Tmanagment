package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.User;
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
    public List<User> findAll() {
        return  userRepository.findAll();
    }

    @Override
    public Page<User> findAll(int page, int size, boolean direction) {
        if(direction)
        return  userRepository.findAll(PageRequest.of(page,size, Sort.by(Sort.Direction.ASC,"name")));
        else return userRepository.findAll(PageRequest.of(page,size, Sort.by(Sort.Direction.DESC,"name")));
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
        return userRepository.save(user);
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
    public void delete(String login) {

    }

    @Override
    public List<User> findAllByProjectId(Long id) {
        return userRepository.findAllByAssignProject(id);
    }
}
