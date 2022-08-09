package com.example.Profile;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.Profile.model.Comment;
import com.example.Profile.model.Company;
import com.example.Profile.model.Language;
import com.example.Profile.model.Post;
import com.example.Profile.model.Profile;
import com.example.Profile.model.ProfileType;
import com.example.Profile.model.ProgramLanguage;
import com.example.Profile.model.User;
import com.example.Profile.service.CommentService;
import com.example.Profile.service.CompanyService;
import com.example.Profile.service.LanguageService;
import com.example.Profile.service.PostService;
import com.example.Profile.service.ProfileService;
import com.example.Profile.service.ProgramLanguageService;
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
	
	@Autowired
	LanguageService languageService;
	
	@Autowired
	ProgramLanguageService programLanguageService;
	
	@Autowired
	ProfileService profileService;
	
	@PostConstruct
	public void init() {
		
		User u1=new User((long)1,"lana","123","Lana","Lanic","lana@gmail.com","3242476777","female","/assets/profilePicture/profile1.jpeg",ProfileType.PRIVATE);
		userService.save(u1);
		
		User u2=new User((long)2,"lana","12345","Lana","Lanic","lanal@hotmail.com","3242476777","female","/assets/profilePicture/profile2.jpeg",ProfileType.PUBLIC);
		userService.save(u2);
		
		User u3=new User((long)3,"marko99","123","Marko","Markovic","markom@gmail.com","3242476777","male","/assets/profilePicture/profile3.jpeg",ProfileType.PRIVATE);
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
		//////////////////////////////////
		ProgramLanguage pl1=new ProgramLanguage((long)1, "C#");
		programLanguageService.save(pl1);
		
		ProgramLanguage pl2=new ProgramLanguage((long)2, "C++");
		programLanguageService.save(pl2);
		
		ProgramLanguage pl3=new ProgramLanguage((long)3, "C");
		programLanguageService.save(pl3);
		
		ProgramLanguage pl4=new ProgramLanguage((long)4, "Java");
		programLanguageService.save(pl4);
		
		ProgramLanguage pl5=new ProgramLanguage((long)5, "Python");
		programLanguageService.save(pl5);
		/////////////////////////////////
		
		Language l1=new Language((long)1, "English");
		languageService.save(l1);
		
		Language l2=new Language((long)2, "Serbian");
		languageService.save(l2);
		
		Language l3=new Language((long)3, "Hungarian");
		languageService.save(l3);
		
		Language l4=new Language((long)4, "Spanish");
		languageService.save(l4);
		
		Language l5=new Language((long)5, "French");
		languageService.save(l5);
		/////////////////////////////////////////////////
		List<ProgramLanguage> pls1=new ArrayList<>();
		pls1.add(pl1);
		pls1.add(pl2);
		
		List<Language> ls1=new ArrayList<>();
		ls1.add(l1);
		ls1.add(l4);
		
		List<String> exCopmanies=new ArrayList<>();
		exCopmanies.add("Vega IT");
		exCopmanies.add("FSD");
		
		Profile pro1=new Profile((long)1, u1, pls1, exCopmanies, ls1, "Faculty of tehnical scientist", "I am very interesting to find a job taht will offer to me a lot of new tehnical skills and new friends.",ProfileType.PRIVATE);
		profileService.save(pro1);
	}
	
}
