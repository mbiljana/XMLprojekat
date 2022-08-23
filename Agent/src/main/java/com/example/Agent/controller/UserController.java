package com.example.Agent.controller;


import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.Agent.dto.UpdateUserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.example.Agent.model.User;
import com.example.Agent.service.UserService;


@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }


    @GetMapping("/user/all")
    @PreAuthorize("hasRole('ADMIN')")
    public List<User> loadAll() {
        return this.userService.findAll();
    }

    @GetMapping("/whoami")
    @PreAuthorize("hasRole('USER')")
    public User user(Principal user) {
        return this.userService.findByKorisnicko(user.getName());
    }

    @GetMapping("/foo")
    public Map<String, String> getFoo() {
        Map<String, String> fooObj = new HashMap<>();
        fooObj.put("foo", "bar");
        return fooObj;
    }
	@RequestMapping(value="/user/{id}",method = RequestMethod.GET)
	public ResponseEntity<User>  findOne(@PathVariable Long id){
		User user=this.userService.findById(id);
		if (user==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} 
		return new ResponseEntity<>(user, HttpStatus.OK);
	}


    //update user profile
    @PutMapping(value = "/user/update",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateProfile(@RequestBody UpdateUserDTO uDTO) throws Exception {

        return new ResponseEntity<User>(this.userService.update(uDTO),HttpStatus.OK);
    }
}
