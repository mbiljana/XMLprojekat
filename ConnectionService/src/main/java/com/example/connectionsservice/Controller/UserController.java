package com.example.connectionsservice.Controller;

import com.example.connectionsservice.Dto.FollowRequestsDTO;
import com.example.connectionsservice.Dto.MessageDTO;
import com.example.connectionsservice.Dto.SentMessageDTO;
import com.example.connectionsservice.Dto.UsersFollowRequests;
import com.example.connectionsservice.Model.Message;
import com.example.connectionsservice.Model.User;
import com.example.connectionsservice.Service.MessageService;
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

    @Autowired
    private MessageService messageService;

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

    //follow a user
    @PostMapping(path = "/follow/{id}/{fid}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> follow(@PathVariable String id,@PathVariable String fid){
        try{
            return new ResponseEntity<User>(userService.follow(id, fid), HttpStatus.OK);
        } catch (IllegalStateException e){
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    //get all follow requests for user
    @PostMapping(path = "/requests",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllFollowRequests(@RequestBody UsersFollowRequests username){
        List<String> followRequests = new ArrayList<>();
        followRequests = userService.getFollowRequests(username.getUsername());
        return new ResponseEntity<List<String>>(followRequests, HttpStatus.OK);
    }
    //get all follow requests for user
    @GetMapping(path = "/requestsId/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllFollowRequestsId(@PathVariable Long id){
        List<String> followRequests = new ArrayList<>();
        followRequests = userService.getFollowRequestsId(id);
        return new ResponseEntity<List<String>>(followRequests, HttpStatus.OK);
    }

    //accept follow request
    @PostMapping (path = "/accept",consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> acceptRequest(@RequestBody FollowRequestsDTO fDTO){
        String userFollowing = userService.confirmRequest(fDTO.followerId, fDTO.toFollowId);
        return new ResponseEntity<String>(userFollowing, HttpStatus.OK);
    }

    //accept follow request another way
    @GetMapping (path = "/accept/{un}/{fun}",consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> acceptRequest(@PathVariable String un, @PathVariable String fun){
        String userFollowing = userService.confirmRequest(un, fun);
        User user = this.userService.findByUsername(un);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @RequestMapping(value="/{username}",method = RequestMethod.GET)
    public ResponseEntity<User>  findOne(@PathVariable String username){
        User profile=this.userService.findByUsername(username);
        if (profile==null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(profile, HttpStatus.OK);
    }






}
