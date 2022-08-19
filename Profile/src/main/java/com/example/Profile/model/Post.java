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
	private String jobDescription;
	private List<String> preconditions;
	private String position;
	private String picture;
	private int numOfLikes;	
	private int numOfDislikes;
	private Company company;
	List<Comment> comments;
	//List<User> followersCanSee;
	
	
	public Post(Long id, String title, String jobDescription, String picture,List<String> preconditions,String position,Company company) {
		super();
		this.id = id;
		this.title = title;
		this.jobDescription = jobDescription;
		this.preconditions=preconditions;
		this.position=position;
		this.picture = picture;
		this.company=company;
		this.numOfLikes = 0;
		this.numOfDislikes = 0;
	}
	public Post(Long id, String title, String jobDescription, List<String> preconditions, String position, String picture,
			int numOfLikes, int numOfDislikes, Company company, List<Comment> comments) {
		super();
		this.id = id;
		this.title = title;
		this.jobDescription = jobDescription;
		this.preconditions = preconditions;
		this.position = position;
		this.picture = picture;
		this.numOfLikes = numOfLikes;
		this.numOfDislikes = numOfDislikes;
		this.company = company;
		this.comments = comments;
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
	
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
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
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public String getJobDescription() {
		return jobDescription;
	}
	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}
	public List<String> getPreconditions() {
		return preconditions;
	}
	public void setPreconditions(List<String> preconditions) {
		this.preconditions = preconditions;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	
}
