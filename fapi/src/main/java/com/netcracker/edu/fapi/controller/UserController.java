package com.netcracker.edu.fapi.controller;

import com.netcracker.edu.fapi.models.User;
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
    public List<User> getAllUsers() {
        return userService.findAll();
    }

    @GetMapping("/login")
    public User getUserByLogin(@RequestParam String login) {
        return userService.findByLogin(login);
    }


    @RequestMapping(method = RequestMethod.POST)
    public User saveUser(@RequestBody User user) {
        System.out.println(user.toString());
        return userService.save(user);
    }

    @RequestMapping(value="/user/project/{id}",method = RequestMethod.GET)
    public List<User> getUserByIdProject(@PathVariable String id) {
        return userService.findByIdProject(Long.valueOf(id));
    }


    @RequestMapping(value="/user/{id}",method = RequestMethod.GET)
    public User getUserById(@PathVariable String id) {
        return userService.findById(Long.valueOf(id));
    }
}
