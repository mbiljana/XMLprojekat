package com.example.Profile.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.Profile.model.UserPost;
import com.example.Profile.service.UserPostService;

@CrossOrigin("*")
@RestController
public class UserPostController {

	@Autowired
	private UserPostService userPostService;
	
	@RequestMapping(value="api/userPost",method = RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserPost> save(@RequestBody UserPost newPost){
		UserPost saved=this.userPostService.save(newPost);
		return new ResponseEntity<>(saved,HttpStatus.CREATED);
	}

}
