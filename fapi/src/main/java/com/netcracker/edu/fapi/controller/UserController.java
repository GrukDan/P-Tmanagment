package com.netcracker.edu.fapi.controller;

import com.netcracker.edu.fapi.models.User;
import com.netcracker.edu.fapi.models.UserViewModel;
import com.netcracker.edu.fapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<UserViewModel> getAllUsers() {
        return userService.findAll();
    }

    @GetMapping("/login")
    public UserViewModel getUserByLogin(@RequestParam String login) {
        return userService.findByLogin(login);
    }


    @RequestMapping(method = RequestMethod.POST)
    public User saveUser(@RequestBody User user) {
        System.out.println(user.toString());
        return userService.save(user);
    }

    @RequestMapping(value="/user/project/{id}",method = RequestMethod.GET)
    public List<UserViewModel> getUserByIdProject(@PathVariable String id) {
        return userService.findByIdProject(Long.valueOf(id));
    }

    @RequestMapping(value="/user/authorization",method = RequestMethod.POST)
    public UserViewModel getUserByLoginAndPassword(@RequestBody User user) {
        return userService.findByLoginAndPassword(user);
    }

    @RequestMapping(value="/user/{id}",method = RequestMethod.GET)
    public UserViewModel getUserById(@PathVariable String id) {
        return userService.findById(Long.valueOf(id));
    }
}
