package com.example.connectionsservice.Controller;

import com.example.connectionsservice.Dto.ChatDTO;
import com.example.connectionsservice.Dto.MessageDTO;
import com.example.connectionsservice.Dto.SentMessageDTO;
import com.example.connectionsservice.Model.Message;
import com.example.connectionsservice.Model.User;
import com.example.connectionsservice.Service.MessageService;
import com.example.connectionsservice.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/messages")
@CrossOrigin("*")
public class MessageController {

    private MessageService messageService;
    private UserService userService;

    @Autowired
    public MessageController(MessageService messageService, UserService userService){
        this.messageService = messageService;
        this.userService = userService;
    }

    @PostMapping(path = "/sendMessage", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> sendMessage(@RequestBody MessageDTO mDTO){
        Message message = this.messageService.sendMessage(mDTO.getSenderUsername(),mDTO.getRecieverUsername(),mDTO.getMessage());
        return new ResponseEntity<Message>(message, HttpStatus.OK);
    }

    //dobavljanje svih poslatih poruka za korisnika
    @GetMapping(path = "/sentMess",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllSentMessages(@RequestBody SentMessageDTO sDTO){
        User user = this.userService.findByUsername(sDTO.getUsername());
        List<Message> messages = user.getSentMessages();
        return new ResponseEntity<List<Message>>(messages, HttpStatus.OK);
    }


    //dobavljanje svih primljenih poruka za korisnika
    @GetMapping(path = "/recMess",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllRecievedMessages(@RequestBody ChatDTO sDTO){
        User user = this.userService.findByUsername(sDTO.getReciever());
        List<Message> messages = this.messageService.findRecievedMessages(user.getUsername(), sDTO.getSender());
        return new ResponseEntity<List<Message>>(messages, HttpStatus.OK);
    }



    //dobavljanje svih poruka - test
    @GetMapping(path = "/allMess",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllMessages(){
        List<Message> messages = this.messageService.getAll();
        return new ResponseEntity<List<Message>>(messages, HttpStatus.OK);
    }

}
