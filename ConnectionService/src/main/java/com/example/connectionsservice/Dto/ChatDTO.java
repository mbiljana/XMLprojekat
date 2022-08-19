package com.example.connectionsservice.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
//@AllArgsConstructor
//@NoArgsConstructor
public class ChatDTO {
    private String sender;
    private String reciever;
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getReciever() {
		return reciever;
	}
	public void setReciever(String reciever) {
		this.reciever = reciever;
	}
	public ChatDTO(String sender, String reciever) {
		super();
		this.sender = sender;
		this.reciever = reciever;
	}
	public ChatDTO() {}
    
}
