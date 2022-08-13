package com.example.Profile.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Profile.model.Comment;
import com.example.Profile.model.Post;
import com.example.Profile.repository.CommentRepository;

@Service
public class CommentService {
	@Autowired
	private CommentRepository commentRepository;
	
	public Comment save(Comment comment) {
		return this.commentRepository.save(comment);
	}
	public List<Comment> findAllCommentsByUserPost(Long id){
		List<Comment> all=this.commentRepository.findAll();
		List<Comment> comments=new ArrayList<>();
		for (Comment com : all) {
			if(com.getUserPost()!=null && com.getUserPost().getId()==id) {
				comments.add(com);
			}
		}
		return comments;
	}
}
