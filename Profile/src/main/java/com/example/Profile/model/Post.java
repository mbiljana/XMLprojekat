package com.example.Profile.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
@Document("posts")
public class Post {
	@Id
	private Long id;
	private String title;
	private String text;
	private String picture;
	private List<String> links;	
	private int numOfLikes;	
	private int numOfDislikes;
	private Company company;
	List<Comment> comments;
	List<User> followersCanSee;
	
	public Post(Long id, String title, String text, String picture, List<String> links, int numOfLikes,
			int numOfDislikes, Company company, List<Comment> comments, List<User> followersCanSee) {
		super();
		this.id = id;
		this.title = title;
		this.text = text;
		this.picture = picture;
		this.links = links;
		this.numOfLikes = numOfLikes;
		this.numOfDislikes = numOfDislikes;
		this.company = company;
		this.comments = comments;
		this.followersCanSee = followersCanSee;
	}
	public Post(Long id, String title, String text, String picture,Company company) {
		super();
		this.id = id;
		this.title = title;
		this.text = text;
		this.picture = picture;
		this.company=company;
		this.numOfLikes = 0;
		this.numOfDislikes = 0;
	}
	public Post() {}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
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
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	
}
