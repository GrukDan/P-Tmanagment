package com.netcracker.edu.fapi.models;

import java.util.Objects;

public class UserViewModel {
    private Long idUser;
    private String name;
    private String surname;
    private String email;
    private Object role;
    private Long assignProject;

    public UserViewModel(){    }

    public UserViewModel(User user){
        if(user!=null) {
            this.idUser = user.getIdUser();
            this.name = user.getName();
            this.surname = user.getSurname();
            this.email = user.getEmail();
            this.role = user.getRole();
            this.assignProject = user.getAssignProject();
        }
    }

    public User getUser(){
        User user  = new User();
        user.setIdUser(idUser);
        user.setName(name);
        user.setSurname(surname);
        user.setEmail(email);
        user.setRole(role);
        user.setAssignProject(assignProject);
        return user;
    }

    public void setUserViewModel(User user){
        this.idUser = user.getIdUser();
        this.name = user.getName();
        this.surname = user.getSurname();
        this.email = user.getEmail();
        this.role = user.getRole();
        this.assignProject = user.getAssignProject();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserViewModel that = (UserViewModel) o;
        return Objects.equals(idUser, that.idUser) &&
                Objects.equals(name, that.name) &&
                Objects.equals(surname, that.surname) &&
                Objects.equals(email, that.email) &&
                Objects.equals(role, that.role) &&
                Objects.equals(assignProject, that.assignProject);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUser, name, surname, email, role, assignProject);
    }

    @Override
    public String toString() {
        return "UserViewModel{" +
                "idUser=" + idUser +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", role=" + role +
                ", assignProject=" + assignProject +
                '}';
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
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

    public Long getAssignProject() {
        return assignProject;
    }

    public void setAssignProject(Long assignProject) {
        this.assignProject = assignProject;
    }

    public UserViewModel(Long idUser, String name, String surname, String email, Object role, Long assignProject) {
        this.idUser = idUser;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.role = role;
        this.assignProject = assignProject;
    }
}
