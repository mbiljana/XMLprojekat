package com.example.Profile.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.Profile.model.Company;
import com.example.Profile.model.Post;
@Repository
public interface PostRepository extends MongoRepository<Post, Long>{

}
