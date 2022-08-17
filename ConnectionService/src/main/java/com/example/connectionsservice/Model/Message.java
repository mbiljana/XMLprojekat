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
@AllArgsConstructor
@NoArgsConstructor
@Document("messages")
public class Message {
    @Id
    private String id;
    private String senderUsername;
    private String recieverUsername;
    private String message;
    private Date sentDate;

    public Message(String senderUsername, String recieverUsername, String message) {
        this.senderUsername = senderUsername;
        this.recieverUsername = recieverUsername;
        this.message = message;
    }
}
