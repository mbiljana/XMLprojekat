package com.example.Profile.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.Profile.model.Comment;
import com.example.Profile.model.Company;
@Repository
public interface CommentRepository extends MongoRepository<Comment, Long>{

}
