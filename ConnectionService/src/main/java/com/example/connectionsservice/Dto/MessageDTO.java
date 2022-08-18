package com.example.connectionsservice.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
//@AllArgsConstructor
//@NoArgsConstructor
public class MessageDTO {
    private String senderUsername;
    private String recieverUsername;
    private String message;
    //private Date sentDate;
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
	public MessageDTO(String senderUsername, String recieverUsername, String message) {
		super();
		this.senderUsername = senderUsername;
		this.recieverUsername = recieverUsername;
		this.message = message;
	}
    
	public MessageDTO() {}

}
