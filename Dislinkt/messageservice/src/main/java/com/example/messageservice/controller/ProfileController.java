package com.example.messageservice.controller;

import com.example.messageservice.model.Chat;
import com.example.messageservice.model.DTO.SendMessageDTO;
import com.example.messageservice.model.DTO.UserDTO;
import com.example.messageservice.model.Message;
import com.example.messageservice.model.Profile;
import com.example.messageservice.service.ChatService;
import com.example.messageservice.service.MessageService;
import com.example.messageservice.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/profile")
public class ProfileController {

    private final ProfileService profileService;
    private final MessageService messageService;
    private final ChatService chatService;

    @Autowired
    public ProfileController(ProfileService profileService, MessageService messageService,ChatService chatService) {
        this.chatService = chatService;
        this.messageService = messageService;
        this.profileService = profileService;
    }


    @PostMapping(value = ("/create"),
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> create(@RequestBody UserDTO uDTO) throws Exception {
        UserDTO user = new UserDTO();
        Profile profile = new Profile();
        if (this.profileService.findByUsername(uDTO.getUsername()) != null) {
            throw new Exception("Username already exists");
        }
        profile.setUsername(uDTO.getUsername());
        user.setUsername(uDTO.getUsername());
        return new ResponseEntity<>(user, HttpStatus.CREATED);

    }



    @PostMapping(value = ("/sendMessage"),
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SendMessageDTO> sendMessage(@RequestBody SendMessageDTO sDTO) throws Exception {
        SendMessageDTO send = new SendMessageDTO();
        Profile sender = new Profile();
        Profile reciver = new Profile();
        sender = this.profileService.findOne(sDTO.getSenderId());
        reciver = this.profileService.findOne(sDTO.getReciverId());
        Chat chat = new Chat();
        boolean chatExists = false;
        Long chatId = -1l;
        for(Chat sc : sender.getChats()) {
            for(Chat rc : reciver.getChats()) {
                if(sc.getId() == rc.getId()) {
                    chatId = sc.getId();
                    chatExists = true;
                    break;
                }
            }
        }
        if(chatExists) {
            chat = this.chatService.findOne(chatId);
            Message newMessage = new Message();
            newMessage.setTime(sDTO.getTime());
            newMessage.setSeen(false);
            newMessage.setText(sDTO.getText());
            newMessage.setMessages(chat);
            this.messageService.create(newMessage);
            chat.getAllMessages().add(newMessage);
            this.chatService.update(chat);
            return new ResponseEntity<>(send, HttpStatus.ACCEPTED);

        }
        else {
            List<Profile> profileList = new ArrayList<>();
            profileList.add(sender);
            profileList.add(reciver);
            chat.setProfilesInChat(profileList);
            this.chatService.create(chat);
            Message newMessage = new Message();
            newMessage.setTime(sDTO.getTime());
            newMessage.setSeen(false);
            newMessage.setText(sDTO.getText());
            newMessage.setMessages(chat);
            this.messageService.create(newMessage);
            chat.getAllMessages().add(newMessage);
            this.chatService.update(chat);
            return new ResponseEntity<>(send, HttpStatus.ACCEPTED);
        }




    }



}
