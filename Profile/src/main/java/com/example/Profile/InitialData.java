package com.example.Profile;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.Profile.model.Comment;
import com.example.Profile.model.Company;
import com.example.Profile.model.Post;
import com.example.Profile.model.User;
import com.example.Profile.service.CommentService;
import com.example.Profile.service.CompanyService;
import com.example.Profile.service.PostService;
import com.example.Profile.service.UserService;

@Component
public class InitialData {

	@Autowired
	CommentService commentService;
	
	@Autowired
	PostService postService;
	
	@Autowired
	CompanyService companyService;
	
	@Autowired
	UserService userService;
	
	@PostConstruct
	public void init() {
		
		User u1=new User((long)1,"lana","123","Lana","Lanic","lana@gmail.com","3242476777","female","/assets/profilePicture/profile1.jpeg");
		userService.save(u1);
		
		User u2=new User((long)2,"lana","12345","Lana","Lanic","lanal@hotmail.com","3242476777","female","/assets/profilePicture/profile2.jpeg");
		userService.save(u2);
		
		User u3=new User((long)3,"marko99","123","Marko","Markovic","markom@gmail.com","3242476777","male","/assets/profilePicture/profile3.jpeg");
		userService.save(u3);
		
		User u4=new User((long)4,"stef","123","Stefan","Stefanovic");
		userService.save(u4);
		///////////////////////////////////
		Company c1=new Company((long) 1, "m&i", "123","M&I", "m&i@gmail.com", "83498234923", "/assets/companyPicture/company1.jpeg");
		companyService.save(c1);
		
		Company c2=new Company((long)2, "symhony", "123","Symhony", "symhony@gmail.com", "83498234923", "/assets/companyPicture/company2.jpeg");
		companyService.save(c2);
		
		Company c3=new Company((long)3, "synehrone", "123","Synehrone", "synehrone@gmail.com", "83498234923", "/assets/companyPicture/company3.jpeg");
		companyService.save(c3);
		//////////////////////////////////
		Post p1=new Post((long)1,"Java developer","Our company looking for junior java developer, experiance is not necessary.","/assets/postPicture/post1.jpeg",c1);
		postService.save(p1);
		
		Post p2=new Post((long)2, "Senior C# programer", "We are looking for senior C# developer, with very good experiance in programing and also communication skills","/assets/postPicture/post2.jpeg",c2);
		postService.save(p2);
		
		Post p3=new Post((long)3, "Senior Java programer", "We are looking for senior Java spring developer developer, with very good experiance in programing and also communication skills","/assets/postPicture/post2.jpeg",c1);
		postService.save(p3);
		
		Post p4=new Post((long)4, "Senior C++ programer", "Hello! We are looking for senior C++ developer, with very good experiance in programing and also communication skills","/assets/postPicture/post4.jpeg",c1);
		postService.save(p4);
		//////////////////////////////////
		Comment com1=new Comment((long)1, "I think that this job offer is not good, beacouse lot of thing",p1);
		commentService.save(com1);
		
		Comment com2=new Comment((long)2, "Excelent",p3);
		commentService.save(com2);
		
		Comment com3=new Comment((long)3, "Excelent job for students",p1);
		commentService.save(com3);
		
	}
	
}
