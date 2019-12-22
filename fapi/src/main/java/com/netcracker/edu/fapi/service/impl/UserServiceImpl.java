package com.netcracker.edu.fapi.service.impl;

import com.netcracker.edu.fapi.models.PaginationModels.UserPaginationModel;
import com.netcracker.edu.fapi.models.PaginationModels.UserPaginationModelResponse;
import com.netcracker.edu.fapi.models.Project;
import com.netcracker.edu.fapi.models.User;
import com.netcracker.edu.fapi.models.ViewModels.UserViewModel;
import com.netcracker.edu.fapi.service.ProjectService;
import com.netcracker.edu.fapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Autowired
    private ProjectService projectService;

//    @Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public List<UserViewModel> findByIdProject(Long idProject) {
        RestTemplate restTemplate = new RestTemplate();
        User[] usersResponse = restTemplate.getForObject(backendServerUrl + "/api/users/idproject/" + idProject, User[].class);
        UserViewModel[] userViewModelsResponse = new UserViewModel[usersResponse.length];
        for (int i = 0; i < userViewModelsResponse.length; i++) {
            userViewModelsResponse[i] = new UserViewModel(usersResponse[i]);
        }
        return usersResponse == null ? Collections.emptyList() : Arrays.asList(userViewModelsResponse);
    }


    @Override
    public UserViewModel findById(Long idUser) {
        RestTemplate restTemplate = new RestTemplate();
        return new UserViewModel((restTemplate.getForObject(backendServerUrl + "/api/user/" + idUser, User.class)));
    }

    //TODO: проверить бэк
    @Override
    public User findByLoginAndPassword(String login, String password) {
        RestTemplate restTemplate = new RestTemplate();
        // user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        User user = new User();
        user.setLogin(login);
        user.setPassword(password);
        return restTemplate.postForEntity(backendServerUrl + "/api/user/authorization", user, User.class).getBody();
    }

    @Override
    public UserPaginationModel findAllSort(String parameter, String page, String size, String direction) {

        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("parameter", parameter);
        map.add("page", page);
        map.add("size", size);
        map.add("direction", direction);

        RestTemplate restTemplate = new RestTemplate();
        String url = UriComponentsBuilder.fromUriString(backendServerUrl + "/api/users")
                .queryParams(map)
                .toUriString();
        UserPaginationModelResponse userPaginationModelResponse = restTemplate.getForObject(url, UserPaginationModelResponse.class);
        UserPaginationModel userPaginationModel = new UserPaginationModel(userPaginationModelResponse);

        UserViewModel[] userViewModels = new UserViewModel[userPaginationModel.getUsersOnPage().size()];
        userPaginationModel.getUsersOnPage().toArray(userViewModels);
        for(int i  = 0;i<userViewModels.length;i++){
            Long idProject = userViewModels[i].getAssignProject();
            if(idProject!=null) {
                System.out.println(idProject + " " + projectService.findById(idProject).getProjectName());
                userViewModels[i].setAssignProjectName(projectService.findById(idProject).getProjectName());
            }
        }
        userPaginationModel.setUsersOnPage(Arrays.asList(userViewModels));
        return userPaginationModel;
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
        //user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        RestTemplate restTemplate = new RestTemplate();
        return new UserViewModel(restTemplate.postForEntity(backendServerUrl + "/api/userviewmodel", userViewModel.getUser(), User.class).getBody());
    }


}
