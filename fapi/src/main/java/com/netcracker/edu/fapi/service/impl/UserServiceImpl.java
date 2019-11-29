package com.netcracker.edu.fapi.service.impl;

import com.netcracker.edu.fapi.models.Task;
import com.netcracker.edu.fapi.models.User;
import com.netcracker.edu.fapi.models.UserViewModel;
import com.netcracker.edu.fapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    @Value("${backend.server.url}")
    private String backendServerUrl;

//    @Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public List<UserViewModel> findByIdProject(Long idProject) {
        RestTemplate restTemplate = new RestTemplate();
        User[] usersResponse = restTemplate.getForObject(backendServerUrl + "/api/users/idproject/" +  idProject, User[].class);
        UserViewModel[] userViewModelsResponse = new UserViewModel[usersResponse.length];
        for(int i = 0; i< userViewModelsResponse.length;i++){
            userViewModelsResponse[i] = new UserViewModel(usersResponse[i]);
        }
        return usersResponse == null ? Collections.emptyList() : Arrays.asList(userViewModelsResponse);
    }


    @Override
    public UserViewModel findById(Long idUser) {
        RestTemplate restTemplate = new RestTemplate();
        return new UserViewModel((restTemplate.getForObject(backendServerUrl + "/api/user/" + idUser, User.class)));
    }

    @Override
    public UserViewModel findByLogin(String login) {
        RestTemplate restTemplate = new RestTemplate();
        return new UserViewModel((restTemplate.getForObject(backendServerUrl + "/api/user/login/" + login, User.class)));
    }

    @Override
    public UserViewModel findByLoginAndPassword(User user) {
        RestTemplate restTemplate = new RestTemplate();
        return new UserViewModel(restTemplate.postForEntity(backendServerUrl + "/api/user/authorization" , user, User.class).getBody());
    }

    @Override
    public List<UserViewModel> findAll() {
        RestTemplate restTemplate = new RestTemplate();
        User[] usersResponse = restTemplate.getForObject(backendServerUrl + "/api/users", User[].class);
        UserViewModel[] userViewModelsResponse = new UserViewModel[usersResponse.length];
        for(int i = 0; i< userViewModelsResponse.length;i++){
            userViewModelsResponse[i] = new UserViewModel(usersResponse[i]);
        }
        return usersResponse == null ? Collections.emptyList() : Arrays.asList(userViewModelsResponse);
    }

    @Override
    public List<UserViewModel> findAllSortByName(int page, int size, int direction) {
        System.out.println(page + "===" + size + "===" + direction);
        RestTemplate restTemplate = new RestTemplate();
        Page<User> usersResponse = restTemplate.getForObject(backendServerUrl + "/api/users/name/" + page + "/" + size + "/" + direction, Page.class);
        //User[] usersResponse = restTemplate.getForObject(backendServerUrl + "/api/users/name/" + page + "/" + size + "/" + direction, User[].class);
        System.out.println(usersResponse.toString());
        List userViewModelsResponse = new ArrayList<UserViewModel>();
        usersResponse.forEach(user -> {
            userViewModelsResponse.add(user);
        });
        return usersResponse == null ? Collections.emptyList() : userViewModelsResponse;
    }

    @Override
    public User save(User user) {
        System.out.println(user.toString());
        // user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api", user, User.class).getBody();
    }

    @Override
    public void deleteById(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + "/api/user/delete/" + id);
    }

    @Override
    public UserViewModel saveUserViewModel(UserViewModel userViewModel) {
        System.out.println(userViewModel.toString());
        // user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        RestTemplate restTemplate = new RestTemplate();
        return new UserViewModel(restTemplate.postForEntity(backendServerUrl + "/api/userviewmodel", userViewModel.getUser(), User.class).getBody());
    }



}
