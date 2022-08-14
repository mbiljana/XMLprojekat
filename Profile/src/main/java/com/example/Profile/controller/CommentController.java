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

import com.example.Profile.model.Comment;
import com.example.Profile.model.User;
import com.example.Profile.model.UserPost;
import com.example.Profile.service.CommentService;

@CrossOrigin("*")
@RestController
public class CommentController {
	@Autowired
	private CommentService commentService;
	
	@RequestMapping(value="api/comment/{postId}", method = RequestMethod.GET,
			produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<List<Comment>> findAllPostsByUser(@PathVariable Long postId){
		List<Comment> comments=this.commentService.findAllCommentsByUserPost(postId);
		return new ResponseEntity<List<Comment>>(comments, HttpStatus.OK);
	}
	@RequestMapping(value="api/comment",method = RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Comment> save(@RequestBody Comment newComment){
		Comment saved=this.commentService.save(newComment);
		return new ResponseEntity<>(saved,HttpStatus.CREATED);
	}
}
