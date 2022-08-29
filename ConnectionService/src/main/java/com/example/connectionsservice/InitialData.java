package com.example.connectionsservice;

import com.example.connectionsservice.Model.Message;
import com.example.connectionsservice.Model.Notification;
import com.example.connectionsservice.Model.User;
import com.example.connectionsservice.Service.MessageService;
import com.example.connectionsservice.Service.NotificationService;
import com.example.connectionsservice.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class InitialData {


    private final UserService userService;

    private final MessageService messageService;

    private final NotificationService notificationService;

    public InitialData(UserService userService,MessageService messageService, NotificationService notificationService ){
        this.userService = userService;
        this.messageService = messageService;
        this.notificationService = notificationService;
    }


    @PostConstruct
    public void init(){
        List<String> flw = new ArrayList<>();
        List<Message> mess = new ArrayList<>();
        List<Message> mess2 = new ArrayList<>();
        List<Notification> notifs = new ArrayList<>();
        
        
        //requests
        List<String> req = new ArrayList<>();
        req.add("stef");
        req.add("maja");
        
        //connections
        List<String> conn = new ArrayList<>();
        conn.add("marko99");
 
        //conn.add("maja");
        Date time = new Date();
        
        
        /////////////messages
        Message m1 = new Message("50","maja","marko99","hi",time);
        messageService.save(m1);

        Message m2 = new Message("51","maja","marko99","caoo",time);
        messageService.save(m2);

        Message m3 = new Message("52","lana99","marko99","hej",time);
        messageService.save(m3);

        //Message m4 = new Message("53","lana99","kica","sta ima",time);
        //messageService.save(m4);


        Message m5 = new Message("53","marko99","lana99","sta ima",time);
        messageService.save(m5);

        List<String> blocked = new ArrayList<>();
        blocked.add("lana99");



        //Notification notif1 = new Notification((long)1, m5, time, "bika");
        //Notification notif2 = new Notification((long)2, m3, time, "kica");
        //this.notificationService.save(notif1);
        //this.notificationService.save(notif2);
        //notifs.add(notif1);
        //notifs.add(notif2);

        User u1=new User((long)1,"lana","123","Lana","Lanic","lana@gmail.com","3242476777","female","/assets/profilePicture/profile1.jpeg",true,conn,flw,mess,mess2,blocked,notifs,notifs);
        User u2=new User((long)2,"lana99","123","Lana","Lanic","lanal@gmail.com","3242476777","female","/assets/profilePicture/profile2.jpeg",false,conn,req,mess,mess2,blocked,notifs,notifs);
        User u3=new User((long)3,"marko99","123","Marko","Markovic","markom@gmail.com","3242476777","male","/assets/profilePicture/profile3.jpeg",true,flw,req,mess,mess2,blocked,notifs,notifs);
        User u4=new User((long)4,"stef","123","Stefan","Stefanovic","stefans@gmail.com","3242476777","male","/assets/profilePicture/profile4-man.jpeg",true,req,flw,mess,mess2,blocked,notifs,notifs);
        User u5=new User((long)5,"maja","123","Maja","Majkovic","maja@gmail.com","3242476777","female","/assets/profilePicture/profile5-female.jpeg",false,req,flw,mess,mess2,blocked,notifs,notifs);
		User u6=new User((long)6,"admin", "123","Nikola","Nikolic", "admin@example.com","3242476777","female","/assets/profilePicture/profile7-admin.jpeg",true,req,flw,mess,mess2,blocked,notifs,notifs);
		
        userService.save(u1);
        userService.save(u2);
        userService.save(u3);
        userService.save(u4);
        userService.save(u5);
        userService.save(u6);
    }


}
