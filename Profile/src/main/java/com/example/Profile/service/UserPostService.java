package com.example.Profile.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Profile.model.Post;
import com.example.Profile.model.Profile;
import com.example.Profile.model.UserPost;
import com.example.Profile.repository.UserPostRepository;
import com.example.Profile.repository.UserRepository;

@Service
public class UserPostService {

	@Autowired
	private UserPostRepository userPostRepository;
	
	public UserPost save(UserPost post) {
		return this.userPostRepository.save(post);
	}
	public List<UserPost> findAllPostsByUser(Long id){
		List<UserPost> allPosts=this.userPostRepository.findAll();
		List<UserPost> posts=new ArrayList<>();
		for (UserPost post : allPosts) {
			if(post.getUser().getId()==id) {
				posts.add(post);
			}
		}
		return posts;
	}
}
