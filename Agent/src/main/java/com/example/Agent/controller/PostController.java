package com.example.Agent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.Agent.dto.PostDTO;
import com.example.Agent.mapper.PostMapper;
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
		Post saved=this.postService.save(post);
		PostDTO dto=PostMapper.convertToDTO(saved);
		return new ResponseEntity<>(dto,HttpStatus.CREATED);
	}
}
