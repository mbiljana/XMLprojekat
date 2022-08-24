package com.example.Agent.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Agent.model.Comment;
import com.example.Agent.repository.CommentRepository;

@Service
public class CommentService {
	@Autowired
	private CommentRepository commentRepository;
	
	public List<Comment> findAllByCopmany(Long id){
		return this.commentRepository.findByCompanyId(id);
	}
}
