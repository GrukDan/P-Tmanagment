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

    @RequestMapping(value="/users/name/{page}/{size}/{direction}",method = RequestMethod.GET)
    public List<UserViewModel> getAllUsersSortByName(@PathVariable(name = "page") String page,
                                                     @PathVariable(name = "size") String size,
                                                     @PathVariable(name = "direction") String direction) {
        System.out.println(page + "== " + size + "direction");
        return userService.findAllSortByName(Integer.parseInt(page),Integer.parseInt(size),Integer.parseInt(direction));
    }

    @GetMapping("/login")
    public UserViewModel getUserByLogin(@RequestParam String login) {
        return userService.findByLogin(login);
    }

    @RequestMapping(value="/userviewmodel",method = RequestMethod.POST)
    public UserViewModel saveUserViewModel(@RequestBody UserViewModel userViewModel) {
        return userService.saveUserViewModel(userViewModel);
    }

    @RequestMapping(method = RequestMethod.POST)
    public User saveUser(@RequestBody User user) {
        return userService.save(user);
    }

    @RequestMapping(value="/user/project/{id}",method = RequestMethod.GET)
    public List<UserViewModel> getUserByIdProject(@PathVariable String id) {
        return userService.findByIdProject(Long.valueOf(id));
    }

    @RequestMapping(value="/user/authorization",method = RequestMethod.POST)
    public UserViewModel getUserByLoginAndPassword(@RequestBody User user) {
        UserViewModel userViewModel = userService.findByLoginAndPassword(user);
        return  userViewModel;
    }

    @RequestMapping(value="/user/{id}",method = RequestMethod.GET)
    public UserViewModel getUserById(@PathVariable(name = "id") String id) {
        return userService.findById(Long.valueOf(id));
    }

    @RequestMapping(value = "/user/delete/{id}",method = RequestMethod.DELETE)
    public void deleteUserById(@PathVariable(name = "id") String id){
        userService.deleteById(Long.valueOf(id));
    }
}
