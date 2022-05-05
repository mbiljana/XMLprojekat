package com.example.followservice.service;

import com.example.followservice.model.FollowRequest;

import java.util.List;

public interface FollowRequestService {
    FollowRequest findOne(Long id);
    List<FollowRequest> findAll();
    FollowRequest create(FollowRequest followRequest) throws Exception;
    void delete(Long id);

}
