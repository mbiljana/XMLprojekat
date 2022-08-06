package com.example.Profile.dto;

import com.example.Profile.model.Company;

public class CompanyDTO {
	private Long id;
	private String username;
	private String password;
	private String name;
	private String email;
	private String mobile;
	private String profilePicture;
	public CompanyDTO(Long id, String username, String password, String name, String email, String mobile,
			String profilePicture) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.profilePicture = profilePicture;
	}
	public CompanyDTO(Company company) {
		this.id = company.getId();
		this.username = company.getUsername();
		this.password = company.getPassword();
		this.name = company.getName();
		this.email = company.getEmail();
		this.mobile = company.getMobile();
		this.profilePicture = company.getProfilePicture();
	}
	public CompanyDTO() {}
}
