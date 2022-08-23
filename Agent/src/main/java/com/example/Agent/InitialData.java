package com.example.Agent;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.Agent.model.Address;
import com.example.Agent.model.Company;
import com.example.Agent.model.Post;
import com.example.Agent.model.Role;
import com.example.Agent.model.User;
import com.example.Agent.repository.AddressRepository;
import com.example.Agent.repository.CompanyRepository;
import com.example.Agent.repository.PostRepository;
import com.example.Agent.service.AddressService;
import com.example.Agent.service.RoleService;
import com.example.Agent.service.UserService;


@Component
public class InitialData {

    private final UserService userService;
    private final RoleService roleService;
    private final AddressRepository addressRepository;
    private final CompanyRepository companyRepository;
    private final PostRepository postRepository;

    @Autowired
    public InitialData(  RoleService roleService, UserService userService,
    		AddressRepository addressRepository,CompanyRepository companyRepository,
    		PostRepository postRepository){
        this.userService = userService;
        this.roleService = roleService;
        this.addressRepository=addressRepository;
        this.companyRepository=companyRepository;
        this.postRepository=postRepository;
    }


    @PostConstruct
    public void init(){
        List<Role> role1 = new ArrayList<>();
        List<Role> role2 = new ArrayList<>();
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
        
        Address a1=new Address((long)1, "Maksima Gorkog 1", "Srbija", "Novi Sad");
        Address a2=new Address((long)2, "Radnicka 1", "Srbija", "Subotica");
        Address a3=new Address((long)3, "Lasla Gaja 3", "Srbija", "Beograd");
        
        addressRepository.save(a1);
        addressRepository.save(a2);
        addressRepository.save(a3);
        
        List<String> preconditions1=new ArrayList<>();
		preconditions1.add("c++");
		preconditions1.add("object-oriented programming");
		preconditions1.add("previous experience");
		
		List<String> preconditions2=new ArrayList<>();
		preconditions2.add("Python");
		preconditions2.add("object-oriented programming");
		preconditions2.add("previous experience");
        
        
        
        Company c1=new Company((long)1, "M&I", "M&I Systems, Co. is a privately held company established in 1991 as Management & Information Systems Company, based in Novi Sad. In almost three decades of operation, M&I Systems, Co. has emerged as the leader when it comes to the development and implementation of information solutions within various industries. Our successful work includes the development of ERP software solutions, business intelligence systems, banking software, specialized software solutions for various industries, as well as the provision of business process management, optimization, and performance management services.", a1, "m&icorporation", "m&i@gmail.com", "34832482", "/assets/companyPicture/m&i.png", u2);
        this.companyRepository.save(c1);
        
        Post p1=new Post((long)1, "Java job offer", "Our company looking for junior java developer, experiance is not necessary.",preconditions1,"Java senior developer", "/assets/postPicture/post1.jpeg", 0,0,c1);
        Post p2=new Post((long)2, "Python job offer", "We are looking for senior Python developer, with very good experiance in programing and also communication skills",preconditions2,"Python junior developer","/assets/postPicture/post2.jpeg", 0,0,c1);
        
        postRepository.save(p1);
        postRepository.save(p2);
        
        
    }
}