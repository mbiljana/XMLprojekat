package com.example.Agent.dto;

import com.example.Agent.model.Address;

public class CompanyDTO {
	private Long id;
	private String name;
	private String description;
	private AddressDTO address;
	private String username;
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
	public AddressDTO getAddress() {
		return address;
	}
	public void setAddress(AddressDTO address) {
		this.address = address;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	public CompanyDTO(Long id, String name, String description, AddressDTO address, String username,
			String email, String mobile, String profilePicture) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.address = address;
		this.username = username;
		this.email = email;
		this.mobile = mobile;
		this.profilePicture = profilePicture;
	}
	public CompanyDTO() {}
	
}
