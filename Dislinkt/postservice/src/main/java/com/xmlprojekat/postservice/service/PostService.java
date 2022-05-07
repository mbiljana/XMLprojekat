package com.xmlprojekat.postservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xmlprojekat.postservice.model.Post;
import com.xmlprojekat.postservice.model.User;
import com.xmlprojekat.postservice.repository.PostRepository;

@Service
public class PostService {
	@Autowired
	private PostRepository postRepository;
	
	public Post save (Post newPost) {
		return this.postRepository.save(newPost);
	}
}
