package com.example.feedservice.service.impl;

import com.example.feedservice.model.Profile;
import com.example.feedservice.repository.ProfileRepository;
import com.example.feedservice.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileServiceImpl implements ProfileService {

    private final ProfileRepository profileRepository;

    @Autowired
    public ProfileServiceImpl(ProfileRepository profileRepository){
        this.profileRepository = profileRepository;
    }

    @Override
    public Profile findOne(Long id) {
        Profile profile = this.profileRepository.findById(id).get();
        return profile;
    }

    @Override
    public Profile findByUsername(String username) {
        Profile profile = this.profileRepository.findByUsername(username);
        return profile;
    }
}
