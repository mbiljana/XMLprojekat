package com.example.connectionsservice;

import com.example.connectionsservice.Model.User;
import com.example.connectionsservice.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class InitialData {


    @Autowired
    UserService userService;


    @PostConstruct
    public void init(){
        User u1=new User((long)1,"lana","123","Lana","Lanic","lana@gmail.com","3242476777","female","/assets/profilePicture/profile1.jpeg");
        userService.save(u1);
    }


}
