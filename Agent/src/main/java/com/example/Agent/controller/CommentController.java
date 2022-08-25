package com.example.Agent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.Agent.model.Comment;
import com.example.Agent.model.Post;
import com.example.Agent.service.CommentService;

import org.springframework.http.MediaType;

@CrossOrigin("*")
@RestController
public class CommentController {
	@Autowired
	private CommentService commentService;
	
	@RequestMapping(value="api/comment/company/{id}",method = RequestMethod.GET)
	public ResponseEntity<List<Comment>>  findAllByCompanyId(@PathVariable Long id){
		List<Comment> comments=this.commentService.findAllByCopmany(id);

		return new ResponseEntity<>(comments, HttpStatus.OK);
	}
	@RequestMapping(value="api/comment",method = RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Comment> save(@RequestBody Comment newComment){
		Comment saved=this.commentService.saveNew(newComment);
		return new ResponseEntity<>(saved,HttpStatus.CREATED);
	}
}
