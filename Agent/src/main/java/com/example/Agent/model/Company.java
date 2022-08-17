package com.example.Agent.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("companies")
public class Company {
	@Id
	private Long id;
	private String name;
	private String description;
	private Address address;
	private String username;
	private String password;
	private String email;
	private String mobile;
	private String profilePicture;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getProfilePicture() {
		return profilePicture;
	}
	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	public Company(Long id, String name, String description, Address address, String username, String password,
			String email, String mobile, String profilePicture) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.address = address;
		this.username = username;
		this.password = password;
		this.email = email;
		this.mobile = mobile;
		this.profilePicture = profilePicture;
	}
	public Company() {}
	
	
	
}