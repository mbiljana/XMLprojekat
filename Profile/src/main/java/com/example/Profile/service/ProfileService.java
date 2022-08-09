package com.example.Profile.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Profile.model.Profile;
import com.example.Profile.model.User;
import com.example.Profile.repository.ProfileRepository;

@Service
public class ProfileService {

	@Autowired
	private ProfileRepository profileRepository;
	
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
}
