package com.xmlprojekat.postservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xmlprojekat.postservice.model.Post;
import com.xmlprojekat.postservice.model.User;
import com.xmlprojekat.postservice.repository.UserRepository;

@Service
public class UserService {
	@Autowired 
	private UserRepository userRepository;
	
	public User getOne(Long id) {
		Optional<User> optUser=this.userRepository.findById(id);
		if (!optUser.isPresent()) {
			return null;
		}
		User user=optUser.get();
		return user;
	}/*
	public void updateUser(User newUser) {
		User user=this.getOne(newUser.getId());
		user.get
	}*/
	public void save (User updateUser) {
		this.userRepository.save(updateUser);
	}
	public List<Post> findAllByUser(Long userId){
		//treba naci usera
		User user=this.getOne(userId);
		//proci kroz njegove postove i njih vratiti
		List<Post> posts=new ArrayList<>();
		//List<Post> rezposts=new ArrayList<>();
		posts=user.getPosts();/*
		for (Post post : posts) {
			rezposts.add(post);
		}*/
		return posts;
	}
}
