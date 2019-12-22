package com.netcracker.edu.fapi.controller;

import com.netcracker.edu.fapi.models.AuthorizationModel;
import com.netcracker.edu.fapi.models.PaginationModels.UserPaginationModel;
import com.netcracker.edu.fapi.models.User;
import com.netcracker.edu.fapi.models.ViewModels.UserViewModel;
import com.netcracker.edu.fapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;
//    private final JwtTokenProvider jwtTokenProvider;
//    private final AuthenticationManager authenticationManager;
//
//    @Autowired
//    public UserController(UserService userService, JwtTokenProvider jwtTokenProvider, AuthenticationManager authenticationManager) {
//        this.jwtTokenProvider = jwtTokenProvider;
//        this.userService = userService;
//        this.authenticationManager = authenticationManager;
//    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public UserPaginationModel getAllUsersSort(@RequestParam("parameter") String parameter,
                                               @RequestParam("page") String page,
                                               @RequestParam("size") String size,
                                               @RequestParam("direction") String direction) {
        UserPaginationModel userPaginationModel = userService.findAllSort(parameter, page, size, direction);
        return userPaginationModel;
    }

    @RequestMapping(value = "/userviewmodel", method = RequestMethod.POST)
    public UserViewModel saveUserViewModel(@RequestBody UserViewModel userViewModel) {
        return userService.saveUserViewModel(userViewModel);
    }

    @RequestMapping(method = RequestMethod.POST)
    public User saveUser(@RequestBody User user) {
        return userService.save(user);
    }

    @RequestMapping(value = "/user/project/{id}", method = RequestMethod.GET)
    public List<UserViewModel> getUserByIdProject(@PathVariable String id) {
        return userService.findByIdProject(Long.valueOf(id));
    }

//    @RequestMapping(value = "/user/authorization", method = RequestMethod.POST)
//    public User getUserByLoginAndPassword(@RequestBody AuthorizationModel authorizationModel) {
//        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authorizationModel.getLogin(), authorizationModel.getPassword()));
//        User user = userService.findByLoginAndPassword(authorizationModel.getLogin(), authorizationModel.getPassword());
//        if(user == null){
//            throw new UsernameNotFoundException("User with login " + authorizationModel.getLogin() + " not found!");
//        }
//        String token = jwtTokenProvider.createToken(authorizationModel.getLogin());
//
//        //TODO: 1/08 Моделька юхера которая содержит токен?
//        return user;
//    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public UserViewModel getUserByLoginAndPassword(@RequestBody AuthorizationModel authorizationModel) {
        User user = userService.findByLoginAndPassword(authorizationModel.getLogin(), authorizationModel.getPassword());
        return new UserViewModel(user);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public UserViewModel getUserById(@PathVariable(name = "id") String id) {
        return userService.findById(Long.valueOf(id));
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public void deleteUserById(@PathVariable(name = "id") String id) {
        userService.deleteById(Long.valueOf(id));
    }
}
