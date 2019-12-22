//package com.netcracker.edu.fapi.security;
//
//import com.netcracker.edu.fapi.models.User;
//import com.netcracker.edu.fapi.models.ViewModels.UserViewModel;
//import com.netcracker.edu.fapi.security.jwt.JwtUser;
//import com.netcracker.edu.fapi.security.jwt.JwtUserFactory;
//import com.netcracker.edu.fapi.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//public class JwtUserDetailsService implements UserDetailsService {
//
//    private final UserService userService;
//
//    @Autowired
//    public JwtUserDetailsService(UserService userService){
//        this.userService = userService;
//    }
//
//
//    //TODO: входные параметры?логин и пароль?
//    @Override
//    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
//        User user = userService.findByLogin(s);
//        if(user == null)
//            throw new UsernameNotFoundException("User with login " + s + " not found");
//        JwtUser jwtUser = JwtUserFactory.create(user);
//        return  jwtUser;
//    }
//}
