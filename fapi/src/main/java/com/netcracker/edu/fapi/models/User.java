package com.netcracker.edu.fapi.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    private int idUser;
    private String name;
    private String surname;
    private String email;
    private Object role;
    private String login;
    private String password;
    private Integer assignProject;

    public User(int idUser, String name, String surname, String email, Object role, String login, String password, Integer assignProject) {
        this.idUser = idUser;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.role = role;
        this.login = login;
        this.password = password;
        this.assignProject = assignProject;
    }



    public Integer getAssignProject() {
        return assignProject;
    }

    public void setAssignProject(Integer assignProject) {
        this.assignProject = assignProject;
    }

    public User() {
    }


    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Object getRole() {
        return role;
    }

    public void setRole(Object role) {
        this.role = role;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "idUser=" + idUser +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", role=" + role +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", assignProject=" + assignProject +
                '}';
    }
}
