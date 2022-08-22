package com.example.Profile.service;

import java.util.ArrayList;
import java.util.List;

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
	
	public List<Post> findAllPostsByCompany(Long id){
		List<Post> allPosts=this.postRepository.findAll();
		List<Post> posts=new ArrayList<>();
		for (Post post : allPosts) {
			if(post.getCompany().getId()==id) {
				posts.add(post);
			}
		}
		return posts;
	}

	public List<Post> searchByTitle(String title){
		List<Post> allPosts = this.postRepository.findByTitle(title);
		return allPosts;
	}

	public List<Post> findAllPosts(){
		return this.postRepository.findAll();
	}

	public Post findPostById(Long id){
		return this.postRepository.findById(id).get();
	}
}
