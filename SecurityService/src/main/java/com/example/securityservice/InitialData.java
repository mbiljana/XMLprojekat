package com.example.securityservice;

import com.example.securityservice.Dto.UserRequest;
import com.example.securityservice.Model.Role;
import com.example.securityservice.Model.User;
import com.example.securityservice.Service.RoleService;
import com.example.securityservice.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Component
public class InitialData {

    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public InitialData(  RoleService roleService, UserService userService){
        this.userService = userService;
        this.roleService = roleService;
    }


    @PostConstruct
    public void init(){
        List<Role> role1 = new ArrayList<>();
        List<Role> role2 = new ArrayList<>();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Role r1 = new Role((long)55, "ROLE_USER");
        Role r2 = new Role((long)56, "ROLE_ADMIN");
        roleService.save(r1);
        roleService.save(r2);
        role1.add(r1);
        role2.add(r2);
        role2.add(r1);
        User u1 = new User((long)1,"user", "$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra","Marko","Markovic", "user@example.com",true,  timestamp,role1);
        User u2 = new User((long)1,"admin", "$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra","Nikola","Nikolic", "admin@example.com",true, timestamp,role2);
        //UserRequest ur1 = new UserRequest("user", "$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra","Marko","Markovic", "user@example.com",true,  timestamp)

        userService.saveUser(u1);
        userService.saveUser(u2);



    }
}
