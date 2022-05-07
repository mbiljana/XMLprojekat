package com.xmlprojekat.postservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xmlprojekat.postservice.model.Comment;
import com.xmlprojekat.postservice.service.CommentService;


@CrossOrigin("*")
@RestController
public class CommentController {
	@Autowired
	private CommentService commentService;
	
	@RequestMapping(value="/api/comment", method = RequestMethod.GET,produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<List<Comment>> findAll(){
		List<Comment> comments=new ArrayList<>();
		comments=this.commentService.findAll();
		return new ResponseEntity<>(comments,HttpStatus.OK);
	}
	
	

}
