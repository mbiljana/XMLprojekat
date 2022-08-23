package com.example.Agent;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import com.example.Agent.model.Address;
import com.example.Agent.model.Company;
import com.example.Agent.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.Agent.model.Role;
import com.example.Agent.model.User;
import com.example.Agent.service.RoleService;
import com.example.Agent.service.UserService;


@Component
public class InitialData {

    private final UserService userService;
    private final RoleService roleService;
    private final CompanyService companyService;

    @Autowired
    public InitialData(RoleService roleService, UserService userService, CompanyService companyService){
        this.userService = userService;
        this.roleService = roleService;
        this.companyService = companyService;
    }


    @PostConstruct
    public void init(){
        List<Role> role1 = new ArrayList<>();
        List<Role> role2 = new ArrayList<>();
        Address address = new Address((long)47, "Stevana Musica 18", "Srbija", "Novi Sad");
        //Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Role r1 = new Role((long)55, "ROLE_USER");
        
        Role r2 = new Role((long)56, "ROLE_ADMIN");
        Role r3 = new Role((long)57, "ROLE_OWNER");
        roleService.save(r1);
        roleService.save(r2);
        roleService.save(r3);
        role1.add(r1);
        role2.add(r2);
        role2.add(r1);
        User u1 = new User((long)1,"lana", "$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra","Lana","Lanic", "lana@gmail.com","3242476777","/assets/profilePicture/profile1.jpeg",true,role1,"User");
        User u2 = new User((long)2,"lana1", "$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra","Lana","Lanic", "lanal@gmail.com","3242476777","/assets/profilePicture/profile2.jpeg",true,role1,"Owner");
        User u3 = new User((long)22,"maja", "$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra","Marko","Markovic", "markom@gmail.com",true,role1,"User");
        User u4 = new User((long)4,"admin", "$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra","Nikola","Nikolic", "admin@example.com",true,role2,"Admin");
        //UserRequest ur1 = new UserRequest("user", "$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra","Marko","Markovic", "user@example.com",true,  timestamp)

        userService.saveUser(u1);
        userService.saveUser(u2);
        userService.saveUser(u3);
        userService.saveUser(u4);

        /////////////////////////////////////////////////////////////////////
        Company c1 = new Company((long)50, "Sotex solutions", "We support clients throughout all the phases of a software product life cycle allowing them to take the benefits of the global market/business modal shift by providing high-quality development services", address, "sotex","sotex@gmail.com","0325648875","/assets/companyPicture/sotex.png",u2);
        companyService.save(c1);
    }
}
