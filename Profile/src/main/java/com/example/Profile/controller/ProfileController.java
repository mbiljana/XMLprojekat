package com.example.Profile.controller;

import com.example.Profile.dto.ProfileUserDTO;
import com.example.Profile.model.User;
import com.example.Profile.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.Profile.dto.UpdateProfileDTO;
import com.example.Profile.model.Language;
import com.example.Profile.model.Profile;
import com.example.Profile.model.ProgramLanguage;
import com.example.Profile.service.LanguageService;
import com.example.Profile.service.ProfileService;
import com.example.Profile.service.ProgramLanguageService;

import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@RestController
public class ProfileController {
	
	@Autowired
	private ProfileService profileService;

	@Autowired
	private UserService userService;
	

	
	@RequestMapping(value="api/profile/{id}",method = RequestMethod.GET)
	public ResponseEntity<Profile>  findOne(@PathVariable Long id){
		Profile profile=this.profileService.findById(id);
		if (profile==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(profile, HttpStatus.OK);
	}

	@RequestMapping(value="api/profile/all",method = RequestMethod.GET)
	public List<Profile> findAll(){
		return this.profileService.findAll();
	}


	//put profile
	@PutMapping(value = "api/profile/update",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> updateProfile(@RequestBody UpdateProfileDTO updateProfile) throws Exception {
		
		return new ResponseEntity<Profile>(this.profileService.updateProfileLists(updateProfile),HttpStatus.OK);
	}


	//create profile from user
	@PostMapping(value = "api/profile/create",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> createProfile(@RequestBody ProfileUserDTO createPr) throws Exception {
		User user = new User();
		user.setId(createPr.getId());
		user.setEmail(createPr.getEmail());
		user.setFirstName(createPr.getFirstName());
		user.setUsername(createPr.getUsername());
		user.setPassword(createPr.getPassword());
		user.setLastName(createPr.getLastName());
		user.setGender(createPr.getGender());
		user.setMobile(createPr.getMobile());
		user.setProfileType(createPr.getProfileType());
		user.setProfilePicture(createPr.getProfilePicture());
		Profile profile = this.profileService.saveUser(user);
		return new ResponseEntity<Profile>(profile,HttpStatus.OK);
	}




}
