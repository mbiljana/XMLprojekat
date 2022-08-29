package com.example.Agent.controller;

import java.util.List;

import com.example.Agent.dto.SearchJobDTO;
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

import com.example.Agent.dto.PostDTO;
import com.example.Agent.mapper.PostMapper;
import com.example.Agent.model.Company;
import com.example.Agent.model.Post;
import com.example.Agent.service.PostService;

@CrossOrigin("*")
@RestController
public class PostController {
	@Autowired
	private PostService postService;
	
	@RequestMapping(value="api/post",method = RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PostDTO> save(@RequestBody PostDTO newPostDTO){
		Post post = PostMapper.convertFromDTO(newPostDTO);
		Post saved=this.postService.saveNew(post);
		PostDTO dto=PostMapper.convertToDTO(saved);
		return new ResponseEntity<>(dto,HttpStatus.CREATED);
	}/*
	@RequestMapping(value="api/post",method = RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Post> save(@RequestBody Post newPost){
		Post saved=this.postService.saveNew(newPost);
		return new ResponseEntity<>(saved,HttpStatus.CREATED);
	}*/
	@RequestMapping(value="api/post/company/{id}",method = RequestMethod.GET)
	public ResponseEntity<List<Post>>  findAllByCompanyId(@PathVariable Long id){
		List<Post> posts=this.postService.findAllByCompanyId(id);

		return new ResponseEntity<>(posts, HttpStatus.OK);
	}
	@RequestMapping(value="api/post/{id}",method = RequestMethod.GET)
	public ResponseEntity<Post>  findById(@PathVariable Long id){
		Post post=this.postService.findById(id);
		if(post==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(post, HttpStatus.OK);
	}

	@RequestMapping(value="api/post/search", method = RequestMethod.POST,
			produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<List<Post>> findAllPostsWithPosition(@RequestBody SearchJobDTO searchJobDTO){
		List<Post> posts=this.postService.searchByPosition(searchJobDTO.getPosition());
		return new ResponseEntity<List<Post>>(posts, HttpStatus.OK);
	}
}
