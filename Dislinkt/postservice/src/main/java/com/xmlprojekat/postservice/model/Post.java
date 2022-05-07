package com.xmlprojekat.postservice.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	String text;
	@Column
	String imageLink;
	@ElementCollection
	List<String> links;
	@Column
	private int numOfLikes;
	@Column
	private int numOfDislikes;
	@OneToMany
	List<Comment> comments;
	@OneToMany
	List<User> followersCanSee;
	//constructors
	public Post() {}
	public Post(Long id, String text, String imageLink, List<String> links, int numOfLikes, int numOfDislikes,
			List<Comment> comments, List<User> followersCanSee) {
		super();
		this.id = id;
		this.text = text;
		this.imageLink = imageLink;
		this.links = links;
		this.numOfLikes = numOfLikes;
		this.numOfDislikes = numOfDislikes;
		this.comments = comments;
		this.followersCanSee = followersCanSee;
	}
	public Post(String text, String imageLink, List<String> links) {
		super();
		this.text = text;
		this.imageLink = imageLink;
		this.links = links;
	}
	//getters and setters
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
	public String getImageLink() {
		return imageLink;
	}
	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}
	public List<String> getLinks() {
		return links;
	}
	public void setLinks(List<String> links) {
		this.links = links;
	}
	public int getNumOfLikes() {
		return numOfLikes;
	}
	public void setNumOfLikes(int numOfLikes) {
		this.numOfLikes = numOfLikes;
	}
	public int getNumOfDislikes() {
		return numOfDislikes;
	}
	public void setNumOfDislikes(int numOfDislikes) {
		this.numOfDislikes = numOfDislikes;
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	public List<User> getFollowersCanSee() {
		return followersCanSee;
	}
	public void setFollowersCanSee(List<User> followersCanSee) {
		this.followersCanSee = followersCanSee;
	}
}
