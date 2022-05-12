package com.example.messageservice.controller;

import com.example.messageservice.service.ChatService;
import com.example.messageservice.service.MessageService;
import com.example.messageservice.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/messages")
public class MessageController {
    private final ProfileService profileService;
    private final MessageService messageService;
    private final ChatService chatService;

    @Autowired
    public MessageController(ProfileService profileService, MessageService messageService,ChatService chatService) {
        this.chatService = chatService;
        this.messageService = messageService;
        this.profileService = profileService;
    }
}
