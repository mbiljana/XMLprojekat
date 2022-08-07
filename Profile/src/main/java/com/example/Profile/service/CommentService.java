package com.example.Profile.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Profile.model.Comment;
import com.example.Profile.repository.CommentRepository;

@Service
public class CommentService {
	@Autowired
	private CommentRepository commentRepository;
	
	public Comment save(Comment comment) {
		return this.commentRepository.save(comment);
	}
}
