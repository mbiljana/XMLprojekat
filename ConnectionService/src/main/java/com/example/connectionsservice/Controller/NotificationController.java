package com.example.connectionsservice.Controller;

import com.example.connectionsservice.Model.Message;
import com.example.connectionsservice.Model.Notification;
import com.example.connectionsservice.Model.User;
import com.example.connectionsservice.Service.MessageService;
import com.example.connectionsservice.Service.NotificationService;
import com.example.connectionsservice.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(path = "/api/notif")
@CrossOrigin("*")
public class NotificationController {

    private final UserService userService;

    private final  MessageService messageService;
    private final NotificationService notificationService;

    @Autowired
    public NotificationController(UserService userService, MessageService messageService,NotificationService notificationService){
        this.userService = userService;
        this.messageService = messageService;
        this.notificationService = notificationService;
    }

    //get all users notifications
    @GetMapping(path = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getUsersNotifs(@PathVariable Long id){
        User user = this.userService.findOne(id);
        List<Notification> usersNotifications = new ArrayList<>();
        try{
            usersNotifications = user.getMessagesNotifications();
        }catch (NullPointerException ne){
            ne.getMessage();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
       // usersNotifications.addAll(postNotifications);
        Collections.sort(usersNotifications, Comparator.comparing(Notification::getDate));
        return new ResponseEntity<List<Notification>>(usersNotifications, HttpStatus.OK);
    }

    @GetMapping(path = "post/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getUsersPostNotifs(@PathVariable Long id){
        User user = this.userService.findOne(id);
        List<Notification> postNotifications = new ArrayList<>();
        try{
            postNotifications = user.getPostNotifications();
        }catch (NullPointerException ne){
            ne.getMessage();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        Collections.sort(postNotifications, Comparator.comparing(Notification::getDate));
        return new ResponseEntity<List<Notification>>(postNotifications, HttpStatus.OK);
    }

    //get notif by id
    @GetMapping(path = "/one/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getOneNotif(@PathVariable Long id){
        Notification notif = this.messageService.getNotif(id);
        return new ResponseEntity<Notification>(notif, HttpStatus.OK);
    }

    //save post notification from user
    @GetMapping(path ="/save/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> savePostNotif(@PathVariable Long id){
        User user = this.userService.findOne(id);
        List<String> following = user.getFollowing();
        for (String f: following) {
            User u = this.userService.findByUsername(f);
            Date d = new Date();
            Notification n = new Notification(d,user.getUsername(), true);
            this.notificationService.saveNotif(n);
            Long last_id=(long)0;
            List<Notification> allNotifs = this.notificationService.findAll();
            for(Notification us : allNotifs){
                last_id  =us.getId();
            }
            n.setId(last_id);
            u.getPostNotifications().add(n);
            userService.save(u);
        }
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }


}
