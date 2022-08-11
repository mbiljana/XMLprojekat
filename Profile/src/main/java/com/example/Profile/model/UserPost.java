package com.example.Profile.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Document("userPosts")
public class UserPost {
	@Id
	private String id;
	private User user;
	private String text;
	private List<String> links;
	private String picture;
	private int likes;
	private int dislikes;
	
	public UserPost() {}
	


	public UserPost(String id, User user, String text, List<String> links, String picture, int likes, int dislikes) {
		super();
		this.id = id;
		this.user = user;
		this.text = text;
		this.links = links;
		this.picture = picture;
		this.likes = likes;
		this.dislikes = dislikes;
	}
	public UserPost( User user, String text, List<String> links, String picture, int likes, int dislikes) {
		super();
		this.user = user;
		this.text = text;
		this.links = links;
		this.picture = picture;
		this.likes = likes;
		this.dislikes = dislikes;
	}



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public List<String> getLinks() {
		return links;
	}

	public void setLinks(List<String> links) {
		this.links = links;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}
	public int getLikes() {
		return likes;
	}
	public void setLikes(int likes) {
		this.likes = likes;
	}
	public int getDislikes() {
		return dislikes;
	}
	public void setDislikes(int dislikes) {
		this.dislikes = dislikes;
	}
	
}
