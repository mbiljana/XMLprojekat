package com.example.Profile.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Profile.model.Language;
import com.example.Profile.model.User;
import com.example.Profile.model.UserPost;
import com.example.Profile.service.LanguageService;

@CrossOrigin("*")
@RestController
public class LanguageController {

	@Autowired
	private LanguageService languageService;
	
	@RequestMapping(value="api/language/{id}",method = RequestMethod.GET)
	public ResponseEntity<Language>  findOne(@PathVariable Long id){
		Language lan=this.languageService.findById(id);
		if (lan==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} 
		return new ResponseEntity<>(lan, HttpStatus.OK);
	}
	
	@RequestMapping(value="api/language",method = RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Language> save(@RequestBody Language lan){
		Language saved=this.languageService.save(lan);
		return new ResponseEntity<>(saved,HttpStatus.CREATED);
	}
	@RequestMapping(value="api/language", method = RequestMethod.GET,
			params = "name",
			produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<Language> findByName(@RequestParam String name){
		Language lan=this.languageService.findByName(name);
		return new ResponseEntity<>(lan,HttpStatus.OK);
	}

}
