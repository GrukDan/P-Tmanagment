package com.netcracker.edu.backend.repository;

import com.netcracker.edu.backend.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    User findByIdUser(Long idUser);

    User findByLogin(String login);

    List<User> findAllByAssignProject(Long assignProject);

    User findByLoginAndPassword(String login, String password);
}
