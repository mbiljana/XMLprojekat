package com.example.messageservice.service.Impl;

import com.example.messageservice.model.Profile;
import com.example.messageservice.repository.ProfileRepository;
import com.example.messageservice.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileServiceImpl implements ProfileService {

    private final ProfileRepository profileRepository;
    @Autowired
    public ProfileServiceImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public Profile findOne(Long id) {
        Profile profile = this.profileRepository.findById(id).get();
        return profile;
    }

    @Override
    public List<Profile> findAll() {
        List<Profile> profili = this.profileRepository.findAll();
        return profili;
    }

    @Override
    public Profile create(Profile profile) throws Exception {
        if(profile.getId() != null){
            throw  new Exception("ID must be null");
        }
        Profile newProfile = this.profileRepository.save(profile);
        return newProfile;
    }

    @Override
    public Profile update(Profile profile) throws Exception {
        Profile updatedProfile = this.profileRepository.findById(profile.getId()).get();
        if(profile.getId() == null){
            throw  new Exception("User doesn't exist");
        }
        updatedProfile.setChats(profile.getChats());
        updatedProfile.setUsername(profile.getUsername());
        Profile updated = this.profileRepository.save(updatedProfile);
        return updated;
    }

    @Override
    public void delete(Long id) {
        this.profileRepository.deleteById(id);
    }
}
