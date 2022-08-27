package com.example.connectionsservice.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
//@AllArgsConstructor
//@NoArgsConstructor
@Document("messages")
public class Message{
    @Id
    private String id;
    private String senderUsername;
    private String recieverUsername;
    private String message;
    private Date sentDate;
	public Message(String id, String senderUsername, String recieverUsername, String message, Date sentDate) {
		super();
		this.id = id;
		this.senderUsername = senderUsername;
		this.recieverUsername = recieverUsername;
		this.message = message;
		this.sentDate = sentDate;
	}
	public Message() {}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSenderUsername() {
		return senderUsername;
	}
	public void setSenderUsername(String senderUsername) {
		this.senderUsername = senderUsername;
	}
	public String getRecieverUsername() {
		return recieverUsername;
	}
	public void setRecieverUsername(String recieverUsername) {
		this.recieverUsername = recieverUsername;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getSentDate() {
		return sentDate;
	}
	public void setSentDate(Date sentDate) {
		this.sentDate = sentDate;
	}
    

    public Message(String senderUsername, String recieverUsername, String message) {
        this.senderUsername = senderUsername;
        this.recieverUsername = recieverUsername;
        this.message = message;
    }

}
