package com.example.connectionsservice.Controller;

import com.example.connectionsservice.Dto.FollowRequestsDTO;
import com.example.connectionsservice.Dto.UsersFollowRequests;
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
    //follow a user
    @PutMapping(path = "/follow",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> follow(@RequestBody FollowRequestsDTO fDTO){
        try{
            return new ResponseEntity<User>(userService.follow(fDTO.followerId, fDTO.toFollowId), HttpStatus.OK);
        } catch (IllegalStateException e){
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    //get all follow requests for user
    @GetMapping(path = "/requests",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllFollowRequests(@RequestBody UsersFollowRequests username){
        List<String> followRequests = new ArrayList<>();
        followRequests = userService.getFollowRequests(username.getUsername());
        return new ResponseEntity<List<String>>(followRequests, HttpStatus.OK);
    }

    //accept follow request
    @PutMapping (path = "/accept",consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> acceptRequest(@RequestBody FollowRequestsDTO fDTO){
        List<String> userFollowing = userService.confirmRequest(fDTO.followerId, fDTO.toFollowId);
        return new ResponseEntity<List<String>>(userFollowing, HttpStatus.OK);
    }

}
