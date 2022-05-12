package com.xmlprojekat.postservice.dto;

import java.util.List;

import com.xmlprojekat.postservice.model.User;

public class PostSaveDTO {
	private Long id;
	private Long userId; 
	private String text;
	private String imageLink;
	private List<String> links;
	private List<User> followersCanSee;
	
	public List<User> getFollowersCanSee() {
		return followersCanSee;
	}

	public void setFollowersCanSee(List<User> followersCanSee) {
		this.followersCanSee = followersCanSee;
	}

	public Long getId() {
		return id;
	}
	
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
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
	public PostSaveDTO(Long id,Long userId, String text, String imageLink, List<String> links,List<User> followersCanSee) {
		super();
		this.id = id;
		this.userId=userId;
		this.text = text;
		this.imageLink = imageLink;
		this.links = links;
		this.followersCanSee=followersCanSee;
	}
	public PostSaveDTO() {}
	
}
