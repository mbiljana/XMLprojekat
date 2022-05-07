package com.xmlprojekat.postservice.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xmlprojekat.postservice.model.Comment;
import com.xmlprojekat.postservice.model.Post;
import com.xmlprojekat.postservice.model.User;
import com.xmlprojekat.postservice.dto.*;
import com.xmlprojekat.postservice.service.PostService;
import com.xmlprojekat.postservice.service.UserService;

@RestController
public class PostController {
	@Autowired
	private PostService postService;
	
	@Autowired
	private UserService userService;
	
	//formiranje novog posta
	@RequestMapping(value="api/posts",method = RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Post> save(@RequestBody PostSaveDTO postDTO){
		Post newPost=new Post(postDTO.getText(), postDTO.getImageLink(), postDTO.getLinks());
		Post savedPost=this.postService.save(newPost);
		User user=this.userService.getOne(postDTO.getUserId());
		user.getPosts().add(savedPost);
		this.userService.save(user);
		return new ResponseEntity<>(savedPost,HttpStatus.CREATED);
	}
	//preuzimanje svih postova jednog korisnika
	@RequestMapping(value="/api/posts/{id}", method = RequestMethod.GET,produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<List<Post>> findAll(@PathVariable Long id){
		List<Post> posts=new ArrayList<>();
		posts=this.userService.findAllByUser(id);
		return new ResponseEntity<>(posts,HttpStatus.OK);
	}
	

}
