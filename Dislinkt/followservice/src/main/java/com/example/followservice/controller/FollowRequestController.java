package com.example.followservice.controller;

import com.example.followservice.model.Connection;
import com.example.followservice.model.DTO.ConnectionDTO;
import com.example.followservice.model.DTO.FRCreateDTO;
import com.example.followservice.model.DTO.FollowReqDTO;
import com.example.followservice.model.DTO.FollowRequestDTO;
import com.example.followservice.model.FollowRequest;
import com.example.followservice.model.Profile;
import com.example.followservice.service.ConnectionService;
import com.example.followservice.service.FollowRequestService;
import com.example.followservice.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/followrequest")
public class FollowRequestController {
    private final ProfileService profileService;
    private final ConnectionService connectionService;
    private final FollowRequestService followRequestService;

    @Autowired
    public FollowRequestController(ProfileService profileService, ConnectionService connectionService, FollowRequestService followRequestService){
        this.connectionService = connectionService;
        this.followRequestService = followRequestService;
        this.profileService = profileService;
    }

    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FollowRequestDTO> getFollowRequest(@PathVariable("id")Long id){
        FollowRequest followRequest = this.followRequestService.findOne(id);
        FollowRequestDTO wantedReq = new FollowRequestDTO();
        wantedReq.setId(followRequest.getId());
        wantedReq.setProfileId(followRequest.getProfile1().getId());
        wantedReq.setReqDate(followRequest.getReqDate());
        return new ResponseEntity<>(wantedReq, HttpStatus.FOUND);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<FollowReqDTO>> getRequests(){
        List<FollowRequest>followRequests = this.followRequestService.findAll();
        List<FollowReqDTO> followRequestDTOS = new ArrayList<>();
        for(FollowRequest f : followRequests){
            FollowReqDTO frDTO = new FollowReqDTO(f.getId(),f.getReqDate());
            followRequestDTOS.add(frDTO);
        }
        return new ResponseEntity<>(followRequestDTOS,HttpStatus.FOUND);
    }

    @PostMapping(value = ("/create"),consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FollowRequestDTO> createRequest(@RequestBody FRCreateDTO frDTO) throws Exception{
        FollowRequest request = new FollowRequest();
        Profile zapracuje = this.profileService.findOne(frDTO.requestingID);
        request.setId(frDTO.getId());
        request.setReqDate(frDTO.getReqDate());
        request.setProfile1(zapracuje);
        Profile zapraceni = this.profileService.findOne(frDTO.followingID);
        FollowRequestDTO followRequestDTO = new FollowRequestDTO(frDTO.getId(), frDTO.getRequestingID(), frDTO.getReqDate());
        if(zapraceni.isPublic == true){
            //kreiranje konekcije izmedju profila
            Connection newConnZapraceni = new Connection();
            newConnZapraceni.setProfile2(zapracuje);
            Connection newConnZapracuje = new Connection();
            newConnZapracuje.setProfile2(zapraceni);
            zapraceni.connections.add(newConnZapraceni);
            zapracuje.connections.add(newConnZapracuje);
            this.profileService.update(zapraceni);
            this.profileService.update(zapracuje);
            return new ResponseEntity<>(followRequestDTO,HttpStatus.OK);
        }else {
            this.followRequestService.create(request);
            zapraceni.followRequests.add(request);
            this.profileService.update(zapraceni);
            return new ResponseEntity<>(followRequestDTO,HttpStatus.CREATED);
        }
    }

    @PostMapping(value = ("/createConnection"),consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ConnectionDTO> createConnection(@RequestBody FRCreateDTO frDTO) throws Exception{
        ConnectionDTO connectionDTO = new ConnectionDTO();
        Profile zapracuje = this.profileService.findOne(frDTO.requestingID);
        Profile zapraceni = this.profileService.findOne(frDTO.followingID);
        Connection newConnZapraceni = new Connection();
        newConnZapraceni.setProfile2(zapracuje);
        Connection newConnZapracuje = new Connection();
        newConnZapracuje.setProfile2(zapraceni);
        zapraceni.connections.add(newConnZapraceni);
        zapracuje.connections.add(newConnZapracuje);
        this.profileService.update(zapraceni);
        this.profileService.update(zapracuje);
        connectionDTO.setPrihvata(zapraceni.getId());
        connectionDTO.setSalje(zapracuje.getId());
        return new ResponseEntity<>(connectionDTO,HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/requests/{id}")
    public ResponseEntity<Void> deleteRequest(@PathVariable Long id){
        this.followRequestService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
