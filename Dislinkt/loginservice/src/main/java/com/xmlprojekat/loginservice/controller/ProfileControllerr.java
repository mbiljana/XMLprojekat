package com.xmlprojekat.loginservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xmlprojekat.loginservice.model.Profile;
import com.xmlprojekat.loginservice.service.ProfileService;

@CrossOrigin("*")
@RestController
public class ProfileControllerr {
	@Autowired
	private ProfileService profileService;
	
	
	  @RequestMapping(value="auth/login",method = RequestMethod.GET,
	  consumes=MediaType.APPLICATION_JSON_VALUE) 
	  public ResponseEntity<Profile> commentPost(@RequestBody Profile profile){ Profile
		  prof=this.profileService.findByUsernameAndPassword(profile.getUsername(),profile.getPassword());
		  if (prof==null) { 
			  return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
		  } 
		  return new ResponseEntity<>(prof,HttpStatus.CREATED); 
		  }
	 
}
