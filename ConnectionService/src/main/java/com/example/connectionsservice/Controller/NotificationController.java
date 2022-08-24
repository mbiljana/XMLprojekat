package com.example.connectionsservice.Controller;

import com.example.connectionsservice.Model.Notification;
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
@RequestMapping(path = "/api/notif")
@CrossOrigin("*")
public class NotificationController {
    @Autowired
    private UserService userService;
    @Autowired
    private MessageService messageService;

    //get all users notifications
    @GetMapping(path = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getUsersNotifs(@PathVariable Long id){
        User user = this.userService.findOne(id);
        List<Notification> usersNotifications = user.getMessagesNotifications();
        if(usersNotifications.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<List<Notification>>(usersNotifications, HttpStatus.OK);
    }

    //get notif by id
    @GetMapping(path = "/one/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getOneNotif(@PathVariable Long id){
        Notification notif = this.messageService.getNotif(id);
        return new ResponseEntity<Notification>(notif, HttpStatus.OK);
    }


}
