package com.example.Agent.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Agent.model.Post;
import com.example.Agent.repository.PostRepository;

@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;
	
	public Post saveUpdate(Post newPost) {
		return this.postRepository.save(newPost);
	}
	public Post saveNew(Post post) {
		Long last_id=(long)0;
		List<Post> all=this.postRepository.findAll();
		for (Post p : all) {
			last_id=p.getId();
		}
		
		last_id=last_id+1;
		post.setId(last_id);
		return this.postRepository.save(post);
	}
}
