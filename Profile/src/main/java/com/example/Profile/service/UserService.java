package com.example.Profile.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Profile.model.User;
import com.example.Profile.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public User save(User user) {
		return this.userRepository.save(user);
	}
	public List<User> findByFirstNameAndLastName(User user) {
		return this.userRepository.findByFirstNameAndLastName(user.getFirstName(),user.getLastName());
	}
}
