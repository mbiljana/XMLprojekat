package com.example.Profile.controller;

import java.util.List;

import com.example.Profile.dto.SearchJobDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

	@RequestMapping(value="api/post/search", method = RequestMethod.POST,
			produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<List<Post>> findAllPostsWithTitle(@RequestBody SearchJobDTO searchJobDTO){
		List<Post> posts=this.postService.searchByTitle(searchJobDTO.getTitle());
		return new ResponseEntity<List<Post>>(posts, HttpStatus.OK);
	}

	@RequestMapping(value="api/post/all", method = RequestMethod.GET,
			produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<List<Post>> findAllPosts(){
		List<Post> posts=this.postService.findAllPosts();
		return new ResponseEntity<List<Post>>(posts, HttpStatus.OK);
	}

	@RequestMapping(value="api/post/one/{id}", method = RequestMethod.GET,
			produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<Post> findById(@PathVariable Long id){
		Post post=this.postService.findPostById(id);
		return new ResponseEntity<Post>(post, HttpStatus.OK);
	}






	
}
