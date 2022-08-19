package com.example.Profile.service;

import java.util.List;
import java.util.Optional;

import com.example.Profile.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Profile.model.Profile;
import com.example.Profile.model.User;
import com.example.Profile.repository.ProfileRepository;

@Service
public class ProfileService {

	@Autowired
	private ProfileRepository profileRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserService userService;
	
	public Profile save(Profile profile) {
		return this.profileRepository.save(profile);
	}


	public Profile findById(Long id) {
		Optional<Profile> profileOpt = this.profileRepository.findById(id);
		if (!profileOpt.isPresent()) {
			return null;
		} else
		{
			return profileOpt.get();
		}
		
	}
	public List<Profile> findAll(){
		return profileRepository.findAll();
	}



	public Profile update(Profile editedUser){
		Profile existingUser = this.findById(editedUser.getId());
		if(existingUser == null){
			throw new IllegalStateException("User does not exist!");
		}
		else{
			User u = this.userService.update(editedUser.getUser());

			return profileRepository.save(editedUser);
		}
	}

}
