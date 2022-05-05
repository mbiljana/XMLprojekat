package com.example.followservice.service.impl;

import com.example.followservice.model.FollowRequest;
import com.example.followservice.model.Profile;
import com.example.followservice.repository.ProfileRepository;
import com.example.followservice.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<Profile> findAll() {
        List<Profile> profiles = this.profileRepository.findAll();
        return profiles;
    }


    @Override
    public Profile getByUsername(String username) {
        Profile profile = this.profileRepository.findByUsername(username);
        return profile;
    }

    @Override
    public Profile update(Profile profile) throws Exception {
        Profile newProfile = this.profileRepository.findById(profile.getId()).get();
        if(profile.getId() == null){
            throw new Exception("User doesn't exist!");
        }
        newProfile.setUsername(profile.getUsername());
        newProfile.setBlocked(profile.isBlocked);
        newProfile.setPublic(profile.isPublic);
        newProfile.setFollowRequests(profile.getFollowRequests());
        newProfile.setConnections(profile.getConnections());

        Profile izmenjen = profileRepository.save(newProfile);
        return izmenjen;
    }

    @Override
    public Profile create(Profile profile) throws Exception {
        if(profile.getId() != null){
            throw new Exception("ID must be null!");
        }
        Profile newFR = this.profileRepository.save(profile);
        return  newFR;
    }
}
