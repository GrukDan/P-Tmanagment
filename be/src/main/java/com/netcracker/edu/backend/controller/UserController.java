package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.entity.User;
import com.netcracker.edu.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user/project/{idProject}", method = RequestMethod.GET)
    public ResponseEntity<User> getUserByIdProject(@PathVariable(name = "idProject") Long idProject) {
        User user = userService.findByIdProject(idProject);
        return ResponseEntity.ok(user);
    }

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

    @RequestMapping(method = RequestMethod.POST)
    public User saveUser(@RequestBody User user) {
        System.out.println(user.toString());
        return userService.save(user);
    }
}
