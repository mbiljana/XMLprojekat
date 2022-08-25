package com.example.connectionsservice;

import com.example.connectionsservice.Model.Message;
import com.example.connectionsservice.Model.User;
import com.example.connectionsservice.Service.MessageService;
import com.example.connectionsservice.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class InitialData {


    @Autowired
    UserService userService;

    @Autowired
    MessageService messageService;


    @PostConstruct
    public void init(){
        List<String> flw = new ArrayList<>();
        List<Message> mess = new ArrayList<>();
        List<Message> mess2 = new ArrayList<>();
        List<String> req = new ArrayList<>();
        req.add("bika");
        req.add("maja");
        List<String> conn = new ArrayList<>();
        conn.add("lana");
        //conn.add("maja");
        Date time = new Date();

        Message m1 = new Message("50","maja","kica","hi",time);
        messageService.save(m1);

        Message m2 = new Message("51","maja","kica","caoo",time);
        messageService.save(m2);

        Message m3 = new Message("52","lana99","kica","hej",time);
        messageService.save(m3);

        //Message m4 = new Message("53","lana99","kica","sta ima",time);
        //messageService.save(m4);


        Message m5 = new Message("53","kica","lana99","sta ima",time);
        messageService.save(m5);

        List<String> blocked = new ArrayList<>();
        blocked.add("lana99");

        User u5=new User((long)1,"lana","123","Lana","Lanic","lana@gmail.com","3242476777","female","/assets/profilePicture/profile1.jpeg",true,conn,flw,mess,mess2,blocked);
        User u1=new User((long)2,"lana99","123","Lana","Lanic","lana@gmail.com","3242476777","female","/assets/profilePicture/profile1.jpeg",true,conn,req,mess,mess2,blocked);
        User u2=new User((long)22,"maja","123","Maja","Majkic","maja@gmail.com","3247876777","female","/assets/profilePicture/profile1.jpeg",true,flw,req,mess,mess2,blocked);
        User u3=new User((long)3,"kica","123","Kica","Kikic","kica@gmail.com","78542476777","male","/assets/profilePicture/profile1.jpeg",false,req,flw,mess,mess2,blocked);
        User u4=new User((long)4,"bika","123","Bika","Bikic","bika@gmail.com","745485175","male","/assets/profilePicture/profile1.jpeg",true,flw,flw,mess,mess2,blocked);


        userService.save(u1);
        userService.save(u2);
        userService.save(u3);
        userService.save(u4);
        userService.save(u5);
    }


}
