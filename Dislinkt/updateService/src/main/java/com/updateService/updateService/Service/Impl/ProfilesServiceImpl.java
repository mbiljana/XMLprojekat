package com.updateService.updateService.Service.Impl;

import com.updateService.updateService.Model.Profiles;
import com.updateService.updateService.Repository.ProfilesRepository;
import com.updateService.updateService.Service.ProfilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfilesServiceImpl implements ProfilesService {
    private final ProfilesRepository profilesRepository;

    @Autowired
    public ProfilesServiceImpl(ProfilesRepository profilesRepository){
        this.profilesRepository = profilesRepository;
    }

    @Override
    public Profiles findOne(Long id){
        Profiles profiles = this.profilesRepository.findById(id).get();
        return profiles;
    }

    @Override
    public List<Profiles> findAll() {
        List<Profiles> profiles = this.profilesRepository.findAll();
        return profiles;
    }


    @Override
    public Profiles getByUsername(String username) {
        Profiles profiles = this.profilesRepository.findByUsername(username);
        return profiles;
    }

    @Override
    public Profiles update(Profiles profiles) throws Exception {
        Profiles newProfiles = this.profilesRepository.findByUsername(profiles.getUsername());

        if(profiles.getUsername() == null){
            throw new Exception("User doesn't exist!");
        }
        else {
            newProfiles.setUsername(profiles.getUsername());
            newProfiles.setName(profiles.getName());
            newProfiles.setSurname(profiles.getSurname());
            newProfiles.setBirthDate(profiles.getBirthDate());
            newProfiles.setEmailAddress(profiles.getEmailAddress());
            newProfiles.setGender(profiles.getGender());
            newProfiles.setPhoneNumber(profiles.getPhoneNumber());
            newProfiles.setPassword(profiles.getPassword());
            newProfiles.setBiography(profiles.getBiography());
            newProfiles.setSkills(profiles.getSkills());
            newProfiles.setWorkExperience(profiles.getWorkExperience());
            newProfiles.setTitle(profiles.getTitle());
            newProfiles.setInterests(profiles.getInterests());
            newProfiles.setEducation(profiles.getEducation());

            Profiles izmenjen = profilesRepository.save(newProfiles);
            return izmenjen;
        }
    }


    @Override
    public Profiles create(Profiles profiles) throws Exception {
        if(profiles.getId() != null){
            throw new Exception("ID must be null!");
        }
        Profiles newFR = this.profilesRepository.save(profiles);
        return  newFR;
    }

    @Override
    public Profiles save(Profiles newProfiles) throws Exception{
        boolean profilesExists = profilesRepository.findByUsername(newProfiles.getUsername()) != null;
        if(profilesExists){
            this.profilesRepository.save(newProfiles);
        }
        return newProfiles;
    }

}

