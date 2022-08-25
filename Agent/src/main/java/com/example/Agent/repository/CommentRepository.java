package com.example.Agent.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.Agent.model.Comment;

public interface CommentRepository extends MongoRepository<Comment, Long>{
	List<Comment> findByCompanyId(Long id);
}
