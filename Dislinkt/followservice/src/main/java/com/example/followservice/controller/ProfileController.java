package com.example.followservice.controller;

import com.example.followservice.model.DTO.ConnectionDTO;
import com.example.followservice.model.DTO.CreateProfileDTO;
import com.example.followservice.model.DTO.FRCreateDTO;
import com.example.followservice.model.DTO.FollowRequestDTO;
import com.example.followservice.model.FollowRequest;
import com.example.followservice.model.Profile;
import com.example.followservice.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/profile")

public class ProfileController {

    private final ProfileService profileService;

    @Autowired
    public ProfileController(ProfileService profileService){
        this.profileService = profileService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CreateProfileDTO> createProfile(@RequestBody CreateProfileDTO cDTO) throws Exception{
        Profile profile = new Profile(cDTO.getId(),cDTO.getUsername(),cDTO.isPublic,cDTO.isBlocked);
        Profile newProfile = this.profileService.create(profile);
        CreateProfileDTO createProfileDTO = new CreateProfileDTO(newProfile.getId(),newProfile.getUsername(),newProfile.isBlocked,newProfile.isPublic);
        return new ResponseEntity<>(createProfileDTO, HttpStatus.CREATED);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CreateProfileDTO>> getRequests(){
        List<Profile>profiles = this.profileService.findAll();
        List<CreateProfileDTO> createProfileDTOS = new ArrayList<>();
        for(Profile f : profiles){
            CreateProfileDTO frDTO = new CreateProfileDTO(f.getId(),f.getUsername(),f.isBlocked,f.isPublic);
            createProfileDTOS.add(frDTO);
        }
        return new ResponseEntity<>(createProfileDTOS,HttpStatus.FOUND);
    }
}

