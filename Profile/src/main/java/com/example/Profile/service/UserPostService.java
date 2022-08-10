package com.example.Profile.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
