package com.example.connectionsservice.Controller;

import com.example.connectionsservice.Dto.ConnectionsNumberDTO;
import com.example.connectionsservice.Model.User;
import com.example.connectionsservice.Service.MessageService;
import com.example.connectionsservice.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping(path = "/api/following")
@CrossOrigin("*")
public class FollowingController {

    private final UserService userService;

    private final MessageService messageService;

    @Autowired
    public FollowingController(UserService userService, MessageService messageService){
        this.messageService = messageService;
        this.userService = userService;
    }

    //get the number of connections user has
    @GetMapping(path = "/numConn/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ConnectionsNumberDTO> getNumberOfUsersConnections(@PathVariable Long id){
        User user = userService.findOne(id);
        int numberConn = userService.getUsersConnections(user.getUsername()).size();
        ConnectionsNumberDTO cDTO = new ConnectionsNumberDTO();
        cDTO.setConnectionsNum(numberConn);
        if(user == null)
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<ConnectionsNumberDTO>(cDTO, HttpStatus.OK);
    }


    //get users connections
    @GetMapping(path="/{id}",  produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<String>>  findOne(@PathVariable Long id){
        User profile=this.userService.findOne(id);
        List<String> connections = profile.getFollowing();
        if (profile==null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<String>>(connections, HttpStatus.OK);
    }



}
