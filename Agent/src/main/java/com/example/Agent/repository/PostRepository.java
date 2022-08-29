package com.example.Agent.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.Agent.model.Post;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, Long>{
    List<Post> findByPosition(String position);
}
