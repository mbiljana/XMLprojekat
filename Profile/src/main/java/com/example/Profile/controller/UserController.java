package com.example.Profile.controller;


import java.util.List;
import java.util.Map;

import com.example.Profile.dto.BlockUserDTO;
import com.example.Profile.model.Profile;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.example.Profile.dto.UserDTO;
import com.example.Profile.model.User;
import com.example.Profile.service.UserService;
@CrossOrigin("*")
@RestController
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="api/user",method = RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<User>> findByFirstNameAndLastName(@RequestBody UserDTO dto){
		User user=new User(dto.getFirstName(),dto.getLastName());
		List<User> users=this.userService.findByFirstNameAndLastName(user);
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
	@RequestMapping(value="api/user/{id}",method = RequestMethod.GET)
	public ResponseEntity<User>  findOne(@PathVariable Long id){
		User user=this.userService.findById(id);
		if (user==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} 
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@RequestMapping(value="api/users",method = RequestMethod.GET)
	public List<User> findAll(){
		return this.userService.findAll();
	}

	@PutMapping(path = "/block",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> block(@RequestBody Map<String, String> block) {
		try {
			return new ResponseEntity<User>(userService.block(block.get("blockerId"), block.get("blockedId")), HttpStatus.OK);
		} catch (IllegalStateException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	//bolja verzija
		@PutMapping (path = "/blockUser",consumes = MediaType.APPLICATION_JSON_VALUE,
				produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<?> acceptRequest(@RequestBody BlockUserDTO fDTO){
			User userFollowing = this.userService.block(fDTO.blockId, fDTO.blockedId);
			return new ResponseEntity<User>(userFollowing, HttpStatus.OK);
		}



}
