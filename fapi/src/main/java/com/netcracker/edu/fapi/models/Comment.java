package com.netcracker.edu.fapi.models;

import java.util.Date;

public class Comment {
    private Long idComment;
    private Date dateOfCreation;
    private Long idUser;
    private Long idTask;
    private String comment;

    @Override
    public String toString() {
        return "Comment{" +
                "idComment=" + idComment +
                ", dateOfCreation=" + dateOfCreation +
                ", idUser=" + idUser +
                ", idTask=" + idTask +
                ", comment='" + comment + '\'' +
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

    public  Comment(){}
    public Comment(Long idComment, Date dateOfCreation, Long idUser, Long idTask, String comment) {
        this.idComment = idComment;
        this.dateOfCreation = dateOfCreation;
        this.idUser = idUser;
        this.idTask = idTask;
        this.comment = comment;
    }
}
