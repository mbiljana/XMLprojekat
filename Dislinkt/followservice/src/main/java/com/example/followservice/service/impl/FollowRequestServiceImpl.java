package com.example.followservice.service.impl;

import com.example.followservice.model.FollowRequest;
import com.example.followservice.repository.FollowRequestRepository;
import com.example.followservice.service.FollowRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FollowRequestServiceImpl implements FollowRequestService {
    private final FollowRequestRepository followRequestRepository;

    @Autowired
    public FollowRequestServiceImpl(FollowRequestRepository followRequestRepository){
        this.followRequestRepository = followRequestRepository;
    }

    @Override
    public FollowRequest findOne(Long id) {
        FollowRequest followRequest = this.followRequestRepository.findById(id).get();
        return followRequest;
    }

    @Override
    public List<FollowRequest> findAll() {
        List<FollowRequest> followRequests = this.followRequestRepository.findAll();
        return followRequests;
    }

    @Override
    public FollowRequest create(FollowRequest followRequest) throws Exception {
        if(followRequest.getId() != null){
            throw new Exception("ID must be null!");
        }
        FollowRequest newFR = this.followRequestRepository.save(followRequest);
        return  newFR;

    }

    @Override
    public void delete(Long id) {
        this.followRequestRepository.deleteById(id);
    }
}
