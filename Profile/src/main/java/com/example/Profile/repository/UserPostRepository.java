package com.example.Profile.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.Profile.model.UserPost;

@Repository
public interface UserPostRepository extends MongoRepository<UserPost, Long>{

}
