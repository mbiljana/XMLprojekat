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

    private String user;
    private Date date;

    private Message messageNotif;
    private boolean post;

    public Notification() {
    }

    public Notification(Long id, Message messageNotif, Date date, String user) {
        this.id = id;
        this.messageNotif = messageNotif;
        this.date = date;
        this.user = user;
    }
    public Notification(Long id, Message messageNotif, Date date) {
        this.id = id;
        this.messageNotif = messageNotif;
        this.date = date;
    }
    public Notification(Message messageNotif, Date date) {
        this.messageNotif = messageNotif;
        this.date = date;
    }
    public Notification(Message messageNotif, Date date, String user) {
        this.messageNotif = messageNotif;
        this.date = date;
        this.user = user;
    }
    public Notification(Date date, String user, boolean post) {
        this.date = date;
        this.user = user;
        this.post = post;
    }

    public boolean isPost() {
        return post;
    }

    public void setPost(boolean post) {
        this.post = post;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
