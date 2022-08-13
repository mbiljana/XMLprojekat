package com.example.Profile.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Document("comments")
public class Comment {
	@Id
	private Long id;
	private String text;
	private Post post;
	private UserPost userPost;
	private User user;
	
	public Comment(Long id, String text, Post post, User user) {
		super();
		this.id = id;
		this.text = text;
		this.post = post;
		this.user = user;
	}
	
	public Comment(Long id, String text, UserPost userPost, User user) {
		super();
		this.id = id;
		this.text = text;
		this.userPost = userPost;
		this.user = user;
	}

	public Comment() {}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
	public UserPost getUserPost() {
		return userPost;
	}
	public void setUserPost(UserPost userPost) {
		this.userPost = userPost;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
