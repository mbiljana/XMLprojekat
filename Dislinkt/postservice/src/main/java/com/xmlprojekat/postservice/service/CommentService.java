package com.xmlprojekat.postservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xmlprojekat.postservice.repository.CommentRepository;
import com.xmlprojekat.postservice.model.*;
@Service
public class CommentService {

	@Autowired
	private CommentRepository commentRepository;
	
	public List<Comment> findAll (){
		return this.commentRepository.findAll();
	}
}
