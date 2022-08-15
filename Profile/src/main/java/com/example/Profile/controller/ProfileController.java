package com.example.Profile.controller;

import com.example.Profile.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.Profile.model.Profile;
import com.example.Profile.service.ProfileService;

import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@RestController
public class ProfileController {
	
	@Autowired
	private ProfileService profileService;

	
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
	@PutMapping(
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> updateProfile(@RequestBody Profile profiles) throws Exception {
		return new ResponseEntity<Profile>(profileService.update(profiles),HttpStatus.OK);
	}


}
