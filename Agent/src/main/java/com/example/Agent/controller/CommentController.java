package com.example.Agent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.Agent.model.Comment;
import com.example.Agent.model.Post;
import com.example.Agent.service.CommentService;

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
}
