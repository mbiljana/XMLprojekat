package com.example.messageservice.model.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SendMessageDTO {
    public Long senderId;
    public Long reciverId;
    public String text;
    public LocalDateTime time;
}
