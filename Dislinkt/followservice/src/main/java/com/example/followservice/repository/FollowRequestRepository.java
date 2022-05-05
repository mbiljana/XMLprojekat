package com.example.followservice.repository;

import com.example.followservice.model.FollowRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FollowRequestRepository extends JpaRepository<FollowRequest,Long> {

}
