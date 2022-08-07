package com.example.Profile.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.Profile.model.Comment;
import com.example.Profile.model.Post;
import com.example.Profile.service.PostService;

@CrossOrigin("*")
@RestController
public class PostController {

	@Autowired
	private PostService postService;
	
}
