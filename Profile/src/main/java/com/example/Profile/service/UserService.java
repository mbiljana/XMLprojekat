package com.example.Profile.service;

import java.util.List;
import java.util.Optional;

import com.example.Profile.model.Profile;
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

	public List<User> findAll(){
		return userRepository.findAll();
	}

	public User findById(Long id) {
		Optional<User> userOpt = this.userRepository.findById(id);
		if (!userOpt.isPresent()) {
			return null;
		} else
		{
			return userOpt.get();
		}
	}

	public User findByUsername(String username){
		User user = userRepository.findByUsername(username);
		if(user == null){
			throw new IllegalStateException("User does not exist!");
		}
		return user;
	}

	public User update(User editedUser){
		User user = this.findById(editedUser.getId());
		user.setFirstName(editedUser.getFirstName());
		user.setEmail(editedUser.getEmail());
		user.setLastName(editedUser.getLastName());
		user.setUsername(editedUser.getUsername());
		user.setMobile(editedUser.getMobile());
		user.setPassword(editedUser.getPassword());
		user.setGender(editedUser.getGender());
		user.setDateOfBirth(editedUser.getDateOfBirth());
		if(user == null){
			throw new IllegalStateException("User does not exist!");
		}
		else{
			return userRepository.save(user);
		}
	}

	public User block(String userBlockingUsername,String userBlockedUsername){
		User userBlocking=userRepository.findByUsername(userBlockingUsername);
		User userBlocked=userRepository.findByUsername(userBlockedUsername);
		if(userBlocking==null){
			throw new IllegalStateException("User who is trying to block does not exist!");
		}

		if(userBlocked==null){
			throw new IllegalStateException("User being blocked does not exist!");
		}

		if(userBlocking.getBlocked().contains(userBlockedUsername)){
			throw new IllegalStateException("You already blocked this user!");
		}

		if(userBlocking.getFollowing().contains(userBlockedUsername)){
			userBlocking.getFollowing().remove(userBlockedUsername);
		}

		if(userBlocking.getFollowRequests().contains(userBlockedUsername)){
			userBlocking.getFollowRequests().remove(userBlockedUsername);
		}

		if(userBlocked.getFollowing().contains(userBlockingUsername)){
			userBlocked.getFollowing().remove(userBlockingUsername);
		}

		if(userBlocked.getFollowRequests().contains(userBlockingUsername)){
			userBlocked.getFollowRequests().remove(userBlockingUsername);
		}
		userBlocking.getBlocked().add(userBlockedUsername);
		userRepository.save(userBlocked);
		return userRepository.save(userBlocking);

	}


}
