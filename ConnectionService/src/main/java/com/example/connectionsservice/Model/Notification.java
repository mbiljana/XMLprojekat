package com.example.connectionsservice.Model;

import org.bson.codecs.pojo.annotations.BsonId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Document("notifications")
public class Notification {
    @Id
    private Long id;

    private User user;

    private Date date;

    private Message messageNotif;

    public Notification() {
    }

    public Notification(Long id, Message messageNotif, User user, Date date) {
        this.id = id;
        this.messageNotif = messageNotif;
        this.user = user;
        this.date = date;
    }
    public Notification(Message messageNotif, User user, Date date) {
        this.messageNotif = messageNotif;
        this.user = user;
        this.date = date;
    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Message getMessageNotif() {
        return messageNotif;
    }

    public void setMessageNotif(Message messageNotif) {
        this.messageNotif = messageNotif;
    }
}
