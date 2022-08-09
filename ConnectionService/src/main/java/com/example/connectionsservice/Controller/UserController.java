package com.example.connectionsservice.Controller;

import com.example.connectionsservice.Model.User;
import com.example.connectionsservice.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/api/users")
@CrossOrigin("*")
public class UserController {
    @Autowired
    private UserService userService;

    //get all users
    @GetMapping(
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllPublicUsers(){
        List<User> users = userService.getAll();
        if(users.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<List<User>>(userService.getAll(), HttpStatus.OK);
    }
    //follow
    @PutMapping(path = "/follow",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> follow(@RequestBody Map<String, String> followRequest){
        try{
            return new ResponseEntity<User>(userService.follow(followRequest.get("followerId"), followRequest.get("toFollowId")), HttpStatus.OK);
        } catch (IllegalStateException e){
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


}
