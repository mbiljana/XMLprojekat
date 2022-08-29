package com.example.Profile.service;

import java.util.ArrayList;
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




	public List<User> findByFirstNameAndLastName(User user) {
		return this.userRepository.findByFirstNameAndLastName(user.getFirstName(),user.getLastName());
	}

	public User saveUser(User user){
		return this.userRepository.save(user);
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

	public User findByUsername(String username) {
		return this.userRepository.findByUsername(username);
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
		user.setProfileType(editedUser.getProfileType());
		if(user == null){
			throw new IllegalStateException("User does not exist!");
		}
		else{
			return userRepository.save(user);
		}
	}

	public String block(String userBlockingUsername,String userBlockedUsername){
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
		userRepository.save(userBlocking);
		String userBl = userBlocked.getUsername();
		return userBl;
	}

	public String confirmRequest(String username, String followerUsername){
		//user koji je primio zahtev
		User user = userRepository.findByUsername(username);
		//user koji je poslao zahtev
		User follower = userRepository.findByUsername(followerUsername);

		//lista ljudi koje prati user koji je zapratio
		List<String> userFollowing = follower.getFollowing();
		List<String> otherSideFollow = user.getFollowing();
		//zahtevi koje je primio user
		List<String> userRequests = user.getFollowRequests();
		for (String f: user.getFollowRequests()
		) {
			if(f.equals(follower.getUsername())){
				userFollowing.add(user.getUsername());
				otherSideFollow.add(follower.getUsername());
				userRequests.remove(f);
				userRepository.save(user);
				userRepository.save(follower);
				break;
			}
		}
		String flw = follower.getUsername();
		return flw;
	}


	public List<String> getBlockedUsers(String username){
		List<String> blocked = new ArrayList<>();
		User user = userRepository.findByUsername(username);
		blocked = user.getBlocked();
		return blocked;
	}
	public List<String> getBlockedUsersId(Long id){
		List<String> blocked = new ArrayList<>();
		User user = userRepository.findById(id).get();
		blocked = user.getBlocked();
		return  blocked;
	}


	//follow a user
	public User follow(String followerUsername, String toFollowUsername) {
		//the user that sent the request
		User followerUser = userRepository.findByUsername(followerUsername);
		//user who got the request from another user
		User toFollowUser = userRepository.findByUsername(toFollowUsername);

		if(followerUser == null){
			throw new IllegalStateException("followerUser does not exist!");
		}
		if(toFollowUser == null){
			throw new IllegalStateException("toFollowUser does not exist!");
		}
		if(followerUser.getFollowing().contains(toFollowUsername)){
			throw new IllegalStateException("You already follow this user!");
		}

			followerUser.getFollowing().add(toFollowUsername);
			toFollowUser.getFollowing().add(followerUsername);
			this.userRepository.save(followerUser);
			this.userRepository.save(toFollowUser);
			userRepository.save(toFollowUser);
			return userRepository.save(followerUser);
	}


}
