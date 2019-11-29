package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.entity.User;
import com.netcracker.edu.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users/idproject/{idProject}", method = RequestMethod.GET)
    public List<User> getAllUsersByIdProject(@PathVariable(name = "idProject") Long idProject) {
        return userService.findAllByProjectId(idProject);
    }

    @RequestMapping(value = "/login/{login}", method = RequestMethod.GET)
    public ResponseEntity<User> getUserByLogin(@PathVariable(name = "login") String login) {
        User user = userService.findByLogin(login);
        return ResponseEntity.ok(user);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> getUserById(@PathVariable(name = "id") Long idUser) {
        User user = userService.findById(idUser);
        return ResponseEntity.ok(user);
    }

    @RequestMapping(value = "/user/authorization", method = RequestMethod.POST)
    public ResponseEntity<User> getUserByLoginAndPassword(@RequestBody User userAuthorization) {
        User user = userService.findByLoginAndPassword(userAuthorization.getLogin(),userAuthorization.getPassword());
        return ResponseEntity.ok(user);
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> getAllUsers() {
        return userService.findAll();
    }

    @RequestMapping(value = "/users/name/{page}/{size}/{direction}", method = RequestMethod.GET)
    public Page<User> getAllUsersSortByName(@PathVariable(name = "page") int page,
                                            @PathVariable(name = "size") int size,
                                            @PathVariable(name = "direction") boolean direction) {
        System.out.println(page + "====" + direction + "!!!");

        return userService.findAll(page,size,direction);
    }

    @RequestMapping(method = RequestMethod.POST)
    public User saveUser(@RequestBody User user) {
        return userService.save(user);
    }

    @RequestMapping(value = "/userviewmodel",method = RequestMethod.POST)
    public User saveUserViewModel(@RequestBody User user) {
        return userService.saveUserViewModel(user);
    }

    @RequestMapping(value = "/user/delete/{id}",method = RequestMethod.DELETE)
    public void deleteUserById(@PathVariable(name = "id") Long id) {
         userService.delete(id);
    }
}
