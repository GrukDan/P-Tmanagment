package com.netcracker.edu.backend.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "comment")
public class Comment {
    private long idComment;
    private Timestamp dateOfCreation;
    private long idUser;
    private long idTask;
    private String comment;

    @Id
    @Column(name = "id_comment")
    public long getIdComment() {
        return idComment;
    }

    public void setIdComment(long idComment) {
        this.idComment = idComment;
    }

    @Basic
    @Column(name = "date_of_creation")
    public Timestamp getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(Timestamp dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    @Basic
    @Column(name = "id_user")
    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    @Basic
    @Column(name = "id_task")
    public long getIdTask() {
        return idTask;
    }

    public void setIdTask(long idTask) {
        this.idTask = idTask;
    }

    @Basic
    @Column(name = "comment")
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment1 = (Comment) o;
        return idComment == comment1.idComment &&
                idUser == comment1.idUser &&
                idTask == comment1.idTask &&
                Objects.equals(dateOfCreation, comment1.dateOfCreation) &&
                Objects.equals(comment, comment1.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idComment, dateOfCreation, idUser, idTask, comment);
    }
}
