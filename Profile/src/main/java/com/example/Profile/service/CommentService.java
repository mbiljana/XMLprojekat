package com.example.Profile.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Profile.model.Comment;
import com.example.Profile.model.Post;
import com.example.Profile.model.UserPost;
import com.example.Profile.repository.CommentRepository;

@Service
public class CommentService {
	@Autowired
	private CommentRepository commentRepository;
	
	public Comment save(Comment com) {
		Long last_id=(long)0;
		List<Comment> all=this.commentRepository.findAll();
		for (Comment comment : all) {/*
			if(com.getUserPost()!=null) {
				if(com.getUserPost()==comment.getUserPost()) {
					System.out.println("user post je isti");
				}
				if(com.getPost()==comment.getPost()) {
					System.out.println("post je isti");
				}
				if(com.getText().equals(comment.getText())) {
					System.out.println("text je isti");
				}
				if(com.getUser().equals(comment.getUser())) {
					System.out.println("user je isti");
				}
				if(com.getUserPost().equals(comment.getUserPost()) & com.getUser().equals(comment.getUser()) & com.getText().equals(comment.getText())) {
					com.setId(comment.getId());
					return this.commentRepository.save(com);
				}
			}
			if(com.getPost()!=null) {
				System.out.println(com.getPost());
				System.out.println(comment.getPost());
				if(com.getPost().equals(comment.getPost())) 
				{
					System.out.println("user post je isti");
				}
				if(com.getText().equals(comment.getText())) {
					System.out.println("text je isti");
				}
				if(com.getUser().equals(comment.getUser())) {
					System.out.println("user je isti");
				}
				if(com.getPost().equals(comment.getPost()) & com.getUser().equals(comment.getUser()) & com.getText().equals(comment.getText())) {
					com.setId(comment.getId());
					return this.commentRepository.save(com);
				}
			}/*
			if(com==comment) {
				com.setId(comment.getId());
				return this.commentRepository.save(com);
			}*/
			if(com.getId()==comment.getId()) {
				return null;
			}
			last_id=comment.getId();
		}
		
		last_id=last_id+1;
		com.setId(last_id);
		return this.commentRepository.save(com);
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
