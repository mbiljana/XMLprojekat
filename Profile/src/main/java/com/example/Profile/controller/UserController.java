package com.example.Profile.controller;


import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.Profile.dto.UserDTO;
import com.example.Profile.model.User;
import com.example.Profile.service.UserService;
@CrossOrigin("*")
@RestController
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="api/user/insert",method = RequestMethod.GET,produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<Void> save(){
		this.userService.save(new User((long)1,"lana","123","Lana","Lanic","lana@gmail.com","3242476777","female","/assets/profilePicture/profile1.jpeg"));
		this.userService.save(new User((long)2,"lana","12345","Lana","Lanic","lanal@hotmail.com","3242476777","female","/assets/profilePicture/profile2.jpeg"));
		this.userService.save(new User((long)3,"marko99","123","Marko","Markovic","markom@gmail.com","3242476777","male","/assets/profilePicture/profile3.jpeg"));
		this.userService.save(new User((long)4,"stef","123","Stefan","Stefanovic"));
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@RequestMapping(value="api/user",method = RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<User>> findByFirstNameAndLastName(@RequestBody UserDTO dto){
		User user=new User(dto.getFirstName(),dto.getLastName());
		List<User> users=this.userService.findByFirstNameAndLastName(user);
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
}
