package com.example.Agent.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Agent.model.Comment;
import com.example.Agent.model.Post;
import com.example.Agent.repository.CommentRepository;

@Service
public class CommentService {
	@Autowired
	private CommentRepository commentRepository;
	
	public List<Comment> findAllByCopmany(Long id){
		return this.commentRepository.findByCompanyId(id);
	}
	public Comment saveNew(Comment comment) {
		Long last_id=(long)0;
		List<Comment> all=this.commentRepository.findAll();
		for (Comment p : all) {
			last_id=p.getId();
		}
		
		last_id=last_id+1;
		comment.setId(last_id);
		return this.commentRepository.save(comment);
	}
}
