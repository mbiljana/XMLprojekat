package com.example.Profile.controller;


import java.util.ArrayList;
import java.util.List;

import com.example.Profile.dto.BlockUserDTO;
import com.example.Profile.dto.ProfileUserDTO;
import com.example.Profile.model.Profile;
import org.springframework.beans.BeanUtils;
import com.example.Profile.dto.BlockNumberDTO;
import com.example.Profile.dto.FollowRequestsDTO;
import com.example.Profile.dto.UsersFollowRequests;
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

	/*@PutMapping(path = "/block",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> block(@RequestBody Map<String, String> block) {
		try {
			return new ResponseEntity<User>(userService.block(block.get("blockerId"), block.get("blockedId")), HttpStatus.OK);
		} catch (IllegalStateException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}*/

	//bolja verzija
	@RequestMapping(value="api/blockUser",method = RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<?> blockUser(@RequestBody FollowRequestsDTO fDTO){
			String userFollowing = this.userService.block(fDTO.followerId, fDTO.toFollowId);
			return new ResponseEntity<String>(userFollowing, HttpStatus.OK);
		}

	@GetMapping(path = "/numBlock/{id}",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BlockNumberDTO> getBlockedUsers(@PathVariable Long id){
		User user = userService.findById(id);
		int numberConn = userService.getBlockedUsers(user.getUsername()).size();
		BlockNumberDTO cDTO = new BlockNumberDTO();
		cDTO.setBlockNum(numberConn);
		if(user == null)
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<BlockNumberDTO>(cDTO, HttpStatus.OK);
	}

		//save user front
		@PostMapping(value = "api/user/create",
				consumes = MediaType.APPLICATION_JSON_VALUE,
				produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<?> createProfile(@RequestBody User createPr) throws Exception {
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
			User profile = this.userService.saveUser(user);
			return new ResponseEntity<User>(profile,HttpStatus.OK);
		}

	@GetMapping(path = "/blocksId/{id}",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getAllFollowRequestsId(@PathVariable Long id){
		List<String> blocks = new ArrayList<>();
		blocks = userService.getBlockedUsersId(id);
		return new ResponseEntity<List<String>>(blocks, HttpStatus.OK);
	}

}
