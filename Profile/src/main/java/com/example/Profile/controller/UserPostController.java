package com.example.Profile.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.Profile.dto.UserLikePostDTO;
import com.example.Profile.model.Post;
import com.example.Profile.model.User;
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

		//adding notifications for all users following this user

		return new ResponseEntity<>(saved,HttpStatus.CREATED);
	}
	
	@RequestMapping(value="api/userPost/like",method = RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserPost> like(@RequestBody UserLikePostDTO dto){
		UserPost saved=this.userPostService.likePost(dto);
		return new ResponseEntity<>(saved,HttpStatus.CREATED);
	}
	
	@RequestMapping(value="api/userPost/dislike",method = RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserPost> dislike(@RequestBody UserLikePostDTO dto){
		UserPost saved=this.userPostService.dislikePost(dto);
		return new ResponseEntity<>(saved,HttpStatus.CREATED);
	}
	
	@RequestMapping(value="api/userPost/user/{userId}", method = RequestMethod.GET,
			produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<List<UserPost>> findAllPostsByUser(@PathVariable Long userId){
		List<UserPost> posts=this.userPostService.findAllPostsByUser(userId);
		return new ResponseEntity<List<UserPost>>(posts, HttpStatus.OK);
	}
	@RequestMapping(value="api/userPost/{id}",method = RequestMethod.GET)
	public ResponseEntity<UserPost>  findOne(@PathVariable Long id){
		UserPost userPost=this.userPostService.findById(id);
		if (userPost==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} 
		return new ResponseEntity<>(userPost, HttpStatus.OK);
	}
	@RequestMapping(value="api/userPost/following/{userId}", method = RequestMethod.GET,
			produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<List<UserPost>> allUserPostFromUsersWhoFollowedByUser(@PathVariable Long userId){
		List<UserPost> posts=this.userPostService.allUserPostFromUsersWhoFollowedByUser(userId);
		return new ResponseEntity<List<UserPost>>(posts, HttpStatus.OK);
	}
	
}
