package com.example.Agent.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("comments")
public class Comment {
	@Id
	private Long id;
	private String text;
	private Company company;
	private User user;
	
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
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
	public Comment(Long id, String text, Company company, User user) {
		super();
		this.id = id;
		this.text = text;
		this.company = company;
		this.user = user;
	}
	public Comment() {}
}
