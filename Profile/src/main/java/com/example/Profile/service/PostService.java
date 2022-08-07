package com.example.Profile.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Profile.model.Post;
import com.example.Profile.repository.PostRepository;

@Service
public class PostService {
	@Autowired
	private PostRepository postRepository;
	
	public Post save(Post post) {
		return this.postRepository.save(post);
	}
}
