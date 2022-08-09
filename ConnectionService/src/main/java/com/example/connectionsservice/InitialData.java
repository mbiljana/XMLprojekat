package com.example.connectionsservice;

import com.example.connectionsservice.Model.User;
import com.example.connectionsservice.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class InitialData {


    @Autowired
    UserService userService;


    @PostConstruct
    public void init(){
        List<String> flw = new ArrayList<>();

        User u1=new User((long)1,"lana","123","Lana","Lanic","lana@gmail.com","3242476777","female","/assets/profilePicture/profile1.jpeg",false,flw,flw);
        User u2=new User((long)2,"maja","123","Maja","Majkic","maja@gmail.com","3247876777","female","/assets/profilePicture/profile1.jpeg",false,flw,flw);
        User u3=new User((long)3,"kica","123","Kica","Kikic","kica@gmail.com","78542476777","male","/assets/profilePicture/profile1.jpeg",false,flw,flw);
        User u4=new User((long)3,"bika","123","Bika","Bikic","bika@gmail.com","745485175","male","/assets/profilePicture/profile1.jpeg",true,flw,flw);
        userService.save(u1);
        userService.save(u2);
        userService.save(u3);
        userService.save(u4);
    }


}
