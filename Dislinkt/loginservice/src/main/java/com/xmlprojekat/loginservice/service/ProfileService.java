package com.xmlprojekat.loginservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xmlprojekat.loginservice.model.Profile;
import com.xmlprojekat.loginservice.repository.ProfileRepository;

@Service
public class ProfileService {
	@Autowired
	private ProfileRepository profileRepository;
	
	public Profile findByUsernameAndPassword(String username,String password) {
		return this.profileRepository.findByUsernameAndPassword(username, password);
	}
}
