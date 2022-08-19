package com.example.Profile.dto;

import com.example.Profile.model.UserPost;

public class UserLikePostDTO {

	private Long userId;
	private UserPost userPost;
	
	public UserLikePostDTO() {}
	public UserLikePostDTO(Long userId, UserPost userPost) {
		super();
		this.userId = userId;
		this.userPost = userPost;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public UserPost getUserPost() {
		return userPost;
	}
	public void setUserPost(UserPost userPost) {
		this.userPost = userPost;
	}
	
	
}
