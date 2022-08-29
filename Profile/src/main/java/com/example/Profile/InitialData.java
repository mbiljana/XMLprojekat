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
import com.example.Profile.model.UserPost;
import com.example.Profile.repository.CommentRepository;
import com.example.Profile.repository.CompanyRepository;
import com.example.Profile.repository.LanguageRepository;
import com.example.Profile.repository.PostRepository;
import com.example.Profile.repository.ProfileRepository;
import com.example.Profile.repository.ProgramLanguageRepository;
import com.example.Profile.repository.UserPostRepository;
import com.example.Profile.repository.UserRepository;

@Component
public class InitialData {

	private final UserRepository userRepository;
	private final UserPostRepository userPostRepository;
	private final ProfileRepository profileRepository;
	private final ProgramLanguageRepository programLanguageRepository;
	private final LanguageRepository languageRepository;
	private final CompanyRepository companyRepository;
	private final PostRepository postRepository;
	private final CommentRepository commentRepository;

	@Autowired
	public InitialData(UserPostRepository userPostRepository, ProfileRepository profileRepository,ProgramLanguageRepository programLanguageRepository,
					   LanguageRepository languageRepository, UserRepository userRepository,CompanyRepository companyRepository,
					   PostRepository postRepository,CommentRepository commentRepository ){
		this.userRepository = userRepository;
		this.userPostRepository = userPostRepository;
		this.profileRepository = profileRepository;
		this.programLanguageRepository = programLanguageRepository;
		this.languageRepository = languageRepository;
		this.companyRepository = companyRepository;
		this.postRepository = postRepository;
		this.commentRepository = commentRepository;

	}
	
	@PostConstruct
	public void init() {

		List<String> following = new ArrayList<>();
		following.add("stef");
		//u following treba da stoji lana99, da bi se videli postovi, posto samo za nju postoje postovi
		following.add("lana");
		
		List<String> following1 = new ArrayList<>();
		following1.add("marko99");

		List<String> followRequests1 = new ArrayList<>();
		followRequests1.add("maja");
		
		List<String> followRequests2 = new ArrayList<>();
		followRequests2.add("maja");
		followRequests2.add("stef");
		
		List<String> followRequests3 = new ArrayList<>();
		followRequests2.add("lana");
		followRequests2.add("lana99");

		List<String> blocked = new ArrayList<>();
		blocked.add("lana99");
	//komentar
		User u1=new User((long)1,"lana","123","Lana","Lanic","lana@gmail.com","3242476777","female","/assets/profilePicture/profile1.jpeg",ProfileType.PRIVATE,following1, followRequests1, blocked, "2000-10-10");
		userRepository.save(u1);
		
		User u2=new User((long)2,"lana99","123","Lana","Lanic","lanal@hotmail.com","3242476777","female","/assets/profilePicture/profile2.jpeg",ProfileType.PUBLIC,following, followRequests2, blocked, "1997-05-05");
		userRepository.save(u2);
		
		User u3=new User((long)3,"marko99","123","Marko","Markovic","markom@gmail.com","3242476777","male","/assets/profilePicture/profile3.jpeg",ProfileType.PRIVATE,following, followRequests3, blocked, "2000-02-02");
		userRepository.save(u3);
		
		User u4=new User((long)4,"stef","123","Stefan","Stefanovic","stefans@gmail.com","3242476777","male","/assets/profilePicture/profile4-man.jpeg",ProfileType.PRIVATE,following, followRequests3, blocked, "2003-03-03");
		userRepository.save(u4);

		User u5=new User((long)5,"maja","123","Maja","Majkovic","maja@gmail.com","3242476777","female","/assets/profilePicture/profile5-female.jpeg",ProfileType.PUBLIC,following, followRequests3, blocked,"1989-08-08");
		userRepository.save(u5);
		
		User u6=new User((long)6,"admin", "123","Nikola","Nikolic", "admin@example.com","3242476777","female","/assets/profilePicture/profile7-admin.jpeg",ProfileType.PRIVATE,following, followRequests3, blocked,"1989-08-08");
		userRepository.save(u6);
		///////////////////////////////////COMPANY///////////////////////////////////////////////////////////
		Company c1=new Company((long) 1, "m&i", "123","M&I", "m&i@gmail.com", "83498234923", "/assets/companyPicture/company1.jpeg");
		companyRepository.save(c1);
		
		Company c2=new Company((long)2, "symhony", "123","Symhony", "symhony@gmail.com", "83498234923", "/assets/companyPicture/company2.png");
		companyRepository.save(c2);
		
		Company c3=new Company((long)3, "synehrone", "123","Synehrone", "synehrone@gmail.com", "83498234923", "/assets/companyPicture/company3.jpeg");
		companyRepository.save(c3);
		
		Company c4=new Company((long)4, "vegaIT", "123","Vega", "vegaag@gmail.com", "83498234923", "/assets/companyPicture/company-vega.png");
		companyRepository.save(c4);
		
		Company c5=new Company((long)5, "continentalIT", "123","Continental", "con@gmail.com", "83498234923", "/assets/companyPicture/company-continental.png");
		companyRepository.save(c5);
		//////////////////////////////////
		List<String> preconditions1=new ArrayList<>();
		preconditions1.add("c++");
		preconditions1.add("object-oriented programming");
		preconditions1.add("previous experience");
		
		List<String> preconditions2=new ArrayList<>();
		preconditions2.add("Python");
		preconditions2.add("object-oriented programming");
		preconditions2.add("previous experience");
		
		List<String> preconditions3=new ArrayList<>();
		preconditions3.add("Angular");
		preconditions3.add("object-oriented programming");
		preconditions3.add("Java");
		
		Post p1=new Post((long)1,"Java developer","Our company looking for junior java developer, experiance is not necessary.","/assets/postPicture/post1.jpeg",preconditions1,"c++ senior developer",c1);
		postRepository.save(p1);
		
		Post p2=new Post((long)2, "Senior AI programer", "We are looking for senior C# developer, with very good experiance in programing and also communication skills","/assets/postPicture/post2.jpeg",preconditions2,"AI junior developer",c2);
		postRepository.save(p2);
		
		Post p3=new Post((long)3, "Junior Java programer", "We are looking for senior Java spring developer developer, with very good experiance in programing and also communication skills","/assets/postPicture/post3.png",preconditions3,"Hava sprign boot junior developer",c1);
		postRepository.save(p3);
		
		Post p4=new Post((long)4, "Senior C++ programer", "Hello! We are looking for senior C++ developer, with very good experiance in programing and also communication skills","/assets/postPicture/post4.jpeg",preconditions1,"c++ senior developer",c1);
		postRepository.save(p4);
		//////////////////////////////////
		Comment com1=new Comment((long)1, "I think that this job offer is not good, beacouse lot of thing",p1,u3);
		commentRepository.save(com1);
		
		Comment com2=new Comment((long)2, "Excelent",p3,u4);
		commentRepository.save(com2);
		
		Comment com3=new Comment((long)3, "Excelent job for students",p1,u4);
		commentRepository.save(com3);
		
		Comment com4=new Comment((long)4, "Excelent job for students",p1,u5);
		commentRepository.save(com4);
		//////////////////////////////////
		ProgramLanguage pl1=new ProgramLanguage((long)1, "C#");
		programLanguageRepository.save(pl1);
		
		ProgramLanguage pl2=new ProgramLanguage((long)2, "C++");
		programLanguageRepository.save(pl2);
		
		ProgramLanguage pl3=new ProgramLanguage((long)3, "C");
		programLanguageRepository.save(pl3);
		
		ProgramLanguage pl4=new ProgramLanguage((long)4, "Java");
		programLanguageRepository.save(pl4);
		
		ProgramLanguage pl5=new ProgramLanguage((long)5, "Python");
		programLanguageRepository.save(pl5);
		/////////////////////////////////
		
		Language l1=new Language((long)1, "English");
		languageRepository.save(l1);
		
		Language l2=new Language((long)2, "Serbian");
		languageRepository.save(l2);
		
		Language l3=new Language((long)3, "Hungarian");
		languageRepository.save(l3);
		
		Language l4=new Language((long)4, "Spanish");
		languageRepository.save(l4);
		
		Language l5=new Language((long)5, "French");
		languageRepository.save(l5);
		/////////////////////////////////////////////////
		List<ProgramLanguage> pls1=new ArrayList<>();
		pls1.add(pl1);
		pls1.add(pl2);
		
		List<ProgramLanguage> pls2=new ArrayList<>();
		pls2.add(pl3);
		pls2.add(pl2);
		pls2.add(pl5);
		////////////////////////////////////////////////
		List<Language> ls1=new ArrayList<>();
		ls1.add(l1);
		ls1.add(l4);
		
		List<Language> ls2=new ArrayList<>();
		ls2.add(l2);
		ls2.add(l3);
		ls2.add(l5);
		
		List<String> exCopmanies=new ArrayList<>();
		exCopmanies.add("Vega IT");
		exCopmanies.add("FSD");


		/////////////////////////////////PROFILE////////////////////////////////////////
		Profile pro1=new Profile((long)1, u1, pls1, exCopmanies, ls1, "Faculty of technical scientist", "I am very interesting to find a job that will offer to me a lot of new technical skills and new friends.",ProfileType.PRIVATE);
		profileRepository.save(pro1);
		
		Profile pro2=new Profile((long)2, u2, pls2, exCopmanies, ls2, "Mathematics faculty", "I am very interesting to find a job that will offer to me a lot of new technical skills and new friends.",ProfileType.PUBLIC);
		profileRepository.save(pro2);
		
		Profile pro3=new Profile((long)3, u3, pls2, exCopmanies, ls1, "Faculty of Organizational Sciences", "I am very interesting to find a job that will offer to me a lot of new technical skills and new friends.",ProfileType.PRIVATE);
		profileRepository.save(pro3);
		
		Profile pro4=new Profile((long)4, u4, pls2, exCopmanies, ls1, "Faculty of technical scientist", "I am very interesting to find a job that will offer to me a lot of new technical skills and new friends.",ProfileType.PRIVATE);
		profileRepository.save(pro4);
		
		Profile pro5=new Profile((long)5, u5, pls1, exCopmanies, ls1, "Faculty of Organizational Sciences", "I am very interesting to find a job that will offer to me a lot of new technical skills and new friends.",ProfileType.PUBLIC);
		profileRepository.save(pro5);
		
		Profile pro6=new Profile((long)6, u6, pls2, exCopmanies, ls1, "Faculty of technical scientist", "I am very interesting to find a job that will offer to me a lot of new technical skills and new friends.",ProfileType.PRIVATE);
		profileRepository.save(pro6);
		/////////////////////////////////////////////////////////////////////////////
		List<String> links1=new ArrayList<String>();
		links1.add("https://dev.java/");
		links1.add("https://getbootstrap.com/docs/4.0/components/buttons/");
		
		List<String> links2=new ArrayList<String>();
		links2.add("https://www.geeksforgeeks.org/go-programming-language-introduction/");
		links2.add("https://getbootstrap.com/docs/4.0/components/buttons/");
		links2.add("https://www.w3schools.com/angular/angular_tables.asp");
		
		UserPost up1=new UserPost((long)1,u1,"Join us October 17-20 in Las Vegas, for the first JavaOne in 5 years. With hundreds of talks from platform architects and industry luminaries, a city-sized developer pavilion, and plenty of networking opportunities, JavaOne is the place to push your Java knowledge to new levels.",links1,"/assets/userPostPicture/post1.jpeg",0, 0);
		userPostRepository.save(up1);
		
		UserPost up2=new UserPost((long)2,u1,"Go is a procedural programming language. It was developed in 2007 by Robert Griesemer, Rob Pike, and Ken Thompson at Google but launched in 2009 as an open-source programming language. Programs are assembled by using packages, for efficient management of dependencies. This language also supports environment adopting patterns alike to dynamic languages. For eg., type inference (y := 0 is a valid declaration of a variable y of type float).",links2,"/assets/userPostPicture/post2.png",0, 0);
		userPostRepository.save(up2);
		
		UserPost up3=new UserPost((long)3,u2,"Artificial intelligence (AI) refers to the simulation of human intelligence in machines that are programmed to think like humans and mimic their actions. The term may also be applied to any machine that exhibits traits associated with a human mind such as learning and problem-solving.",links1,"/assets/userPostPicture/post3.jpeg",0, 0);
		userPostRepository.save(up3);
		
		UserPost up4=new UserPost((long)4,u2,"Mathematical logic is the study of formal logic within mathematics. Major subareas include model theory, proof theory, set theory, and recursion theory. Research in mathematical logic commonly addresses the mathematical properties of formal systems of logic such as their expressive or deductive power.",links2,"/assets/userPostPicture/post4.jpeg",0, 0);
		userPostRepository.save(up4);
		UserPost up5=new UserPost((long)5,u3,"Google LLC is an American multinational technology company that focuses on search engine technology, online advertising, cloud computing, computer software, quantum computing, e-commerce, artificial intelligence, and consumer electronics.",links2,"/assets/userPostPicture/post5.jpeg",0, 0);
		userPostRepository.save(up5);
		UserPost up6=new UserPost((long)6,u5,"founded in 2010 by Kevin Systrom and Mike Krieger, and later acquired by American company Facebook Inc., now known as Meta Platforms. The app allows users to upload media that can be edited with filters and organized by hashtags and geographical tagging. Posts can be shared publicly or with ",links2,"/assets/userPostPicture/post1.jpeg",0, 0);
		userPostRepository.save(up6);
		/////////////////////////////COMMMENTS for user posts////////////////////////////////////////
		Comment com5=new Comment((long)5, "I think that this job offer is not good, beacouse lot of thing. OK",up1,u3);
		commentRepository.save(com5);
		
		Comment com6=new Comment((long)6, "Excelent job for everyone who want to lear new things",up2,u4);
		commentRepository.save(com6);
		
		Comment com7=new Comment((long)7, "Excelent job for students and",up1,u2);
		commentRepository.save(com7);
	}
	
}
