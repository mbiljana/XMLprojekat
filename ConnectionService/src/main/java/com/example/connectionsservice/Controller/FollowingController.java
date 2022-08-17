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

    @GetMapping(path = "/numConn",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ConnectionsNumberDTO> getNumberOfUsersConnections(@RequestParam String username){
        User user = userService.findByUsername(username);
        int numberConn = userService.getNumConnectionsForUser(user.getUsername()).size();
        ConnectionsNumberDTO cDTO = new ConnectionsNumberDTO();
        cDTO.setConnectionsNum(numberConn);
        if(user == null)
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<ConnectionsNumberDTO>(cDTO, HttpStatus.OK);
    }
}
