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
	public Comment(Long id, String text,Post post) {
		super();
		this.id = id;
		this.text = text;
		this.post=post;
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
	
}
