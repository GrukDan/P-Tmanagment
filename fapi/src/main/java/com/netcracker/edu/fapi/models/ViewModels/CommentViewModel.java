package com.netcracker.edu.fapi.models.ViewModels;

import com.netcracker.edu.fapi.models.Comment;

import java.util.Date;

public class CommentViewModel {

    private Long idComment;
    private Date dateOfCreation;
    private Long idUser;
    private Long idTask;
    private String comment;

    private String name;//user name
    private String surname;

    @Override
    public String toString() {
        return "CommentViewModel{" +
                "idComment=" + idComment +
                ", dateOfCreation=" + dateOfCreation +
                ", idUser=" + idUser +
                ", idTask=" + idTask +
                ", comment='" + comment + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }

    public Long getIdComment() {
        return idComment;
    }

    public void setIdComment(Long idComment) {
        this.idComment = idComment;
    }

    public Date getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(Date dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public Long getIdTask() {
        return idTask;
    }

    public void setIdTask(Long idTask) {
        this.idTask = idTask;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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

    public CommentViewModel(Long idComment, Date dateOfCreation, Long idUser, Long idTask, String comment, String name, String surname) {
        this.idComment = idComment;
        this.dateOfCreation = dateOfCreation;
        this.idUser = idUser;
        this.idTask = idTask;
        this.comment = comment;
        this.name = name;
        this.surname = surname;
    }

    public CommentViewModel(Comment comment) {
        this.idComment = comment.getIdComment();
        this.dateOfCreation = comment.getDateOfCreation();
        this.idUser = comment.getIdUser();
        this.idTask = comment.getIdTask();
        this.comment = comment.getComment();
    }
}
