package com.netcracker.edu.backend.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Message {
    private int idMessage;
    private int idSender;
    private int idRecipient;
    private Timestamp datetimeMessage;
    private String message;

    @Id
    @Column(name = "id_message")
    public int getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(int idMessage) {
        this.idMessage = idMessage;
    }

    @Basic
    @Column(name = "id_sender")
    public int getIdSender() {
        return idSender;
    }

    public void setIdSender(int idSender) {
        this.idSender = idSender;
    }

    @Basic
    @Column(name = "id_recipient")
    public int getIdRecipient() {
        return idRecipient;
    }

    public void setIdRecipient(int idRecipient) {
        this.idRecipient = idRecipient;
    }

    @Basic
    @Column(name = "datetime_message")
    public Timestamp getDatetimeMessage() {
        return datetimeMessage;
    }

    public void setDatetimeMessage(Timestamp datetimeMessage) {
        this.datetimeMessage = datetimeMessage;
    }

    @Basic
    @Column(name = "message")
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message1 = (Message) o;
        return idMessage == message1.idMessage &&
                idSender == message1.idSender &&
                idRecipient == message1.idRecipient &&
                Objects.equals(datetimeMessage, message1.datetimeMessage) &&
                Objects.equals(message, message1.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMessage, idSender, idRecipient, datetimeMessage, message);
    }
}
