package com.updateService.updateService.Controller;

import com.updateService.updateService.Model.DTO.ProfilesDTO;
import com.updateService.updateService.Model.Profiles;
import com.updateService.updateService.Service.ProfilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value= "api/profiles")
public class ProfilesController {
    private final ProfilesService profilesService;


    @Autowired
    public ProfilesController(ProfilesService profilesService) {
        this.profilesService = profilesService;
    }


    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProfilesDTO> createProfile(@RequestBody ProfilesDTO DTO) throws Exception {
        Profiles existing = this.profilesService.getByUsername(DTO.getUsername());
        //ako postoji vec takav username
        if(existing != null){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        } else {
            Profiles profiles = new Profiles();
            profiles.setName(DTO.getName());
            profiles.setSurname(DTO.getSurname());
            profiles.setBirthDate(DTO.getBirthDate());
            profiles.setGender(DTO.getGender());
            profiles.setEmailAddress(DTO.getEmailAddress());
            profiles.setUsername(DTO.getUsername());
            profiles.setPassword(DTO.getPassword());
            profiles.setPhoneNumber(DTO.getPhoneNumber());
            profiles.setBiography(DTO.getBiography());
            profiles.setSkills(DTO.getSkills());
            profiles.setWorkExperience(DTO.getWorkExperience());
            profiles.setTitle(DTO.getTitle());
            profiles.setInterests(DTO.getInterests());
            profiles.setEducation(DTO.getEducation());
            Profiles newProfiles = this.profilesService.create(profiles);

            ProfilesDTO createProfileDTO = new ProfilesDTO(newProfiles.getBirthDate(), newProfiles.getName(), newProfiles.getSurname(), newProfiles.getEmailAddress(), newProfiles.getPhoneNumber(),
                    newProfiles.getPassword(), newProfiles.getGender(), newProfiles.getUsername(), newProfiles.getBiography(), newProfiles.getTitle(), newProfiles.getEducation(),
                    newProfiles.getWorkExperience(), newProfiles.getSkills(), newProfiles.getInterests());
            return new ResponseEntity<>(createProfileDTO, HttpStatus.CREATED);
        }
    }

    @PutMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateProfile(@RequestBody Profiles profiles) throws Exception {
        return new ResponseEntity<Profiles>(profilesService.update(profiles),HttpStatus.OK);
    }

}