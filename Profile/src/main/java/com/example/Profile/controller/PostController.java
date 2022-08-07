package com.example.Profile.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Profile.model.Post;
import com.example.Profile.service.PostService;

@CrossOrigin("*")
@RestController
public class PostController {

	@Autowired
	private PostService postService;
	
	@RequestMapping(value="api/post/{companyId}", method = RequestMethod.GET,
			produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<List<Post>> findAllPostsByCompany(@PathVariable Long companyId){
		List<Post> posts=this.postService.findAllPostsByCompany(companyId);
		return new ResponseEntity<List<Post>>(posts, HttpStatus.OK);
	}
	
}
