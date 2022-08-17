package com.example.Agent.dto;

import java.util.List;

import com.example.Agent.model.Company;

public class PostDTO {
	private Long id;
	private String title;
	private String jobDescription;
	private List<String> preconditions;
	private String position;
	private String picture;
	private int numOfLikes;	
	private int numOfDislikes;
	private CompanyDTO company;
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
	public CompanyDTO getCompany() {
		return company;
	}
	public void setCompany(CompanyDTO company) {
		this.company = company;
	}
	public PostDTO(Long id, String title, String jobDescription, List<String> preconditions, String position,
			String picture, int numOfLikes, int numOfDislikes, CompanyDTO company) {
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
	}
	public PostDTO() {}
	
}
