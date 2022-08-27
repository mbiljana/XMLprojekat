package com.example.Profile.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Getter;
import lombok.Setter;

import javax.management.Notification;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@Document("users")
public class User {
	
	@Id
	private Long id;
	
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String dateOfBirth;
	private String email;
	private String mobile;
	private String gender;
	private String profilePicture;
	private ProfileType profileType;
	private boolean isPrivate;

	private List<String> following;
	private List<String> followRequests;
	private List<String> blocked;
	
	public User() {}


	public User(Long id, String username, String password, String firstName, String lastName) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public User(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public User(Long id, String username, String password, String firstName, String lastName, String email,
			String mobile, String gender, String profilePicture, ProfileType profileType) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobile = mobile;
		this.gender = gender;
		this.profilePicture = profilePicture;
		this.profileType = profileType;
	}

	public User(Long id, String username, String password, String firstName, String lastName, String email, String mobile, String gender, String profilePicture, ProfileType profileType, List<String> following, List<String> followRequests, List<String> blocked, String dateOfBirth) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobile = mobile;
		this.gender = gender;
		this.profilePicture = profilePicture;
		this.profileType = profileType;
		this.following = following;
		this.followRequests = followRequests;
		this.blocked = blocked;
		this.dateOfBirth = dateOfBirth;
	}

	public User(Long id, String username, String password, String firstName, String lastName, String dateOfBirth, String email, String mobile, String gender, String profilePicture, ProfileType profileType, boolean isPrivate, List<String> following, List<String> followRequests, List<String> blocked) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.email = email;
		this.mobile = mobile;
		this.gender = gender;
		this.profilePicture = profilePicture;
		this.profileType = profileType;
		this.isPrivate = isPrivate;
		this.following = following;
		this.followRequests = followRequests;
		this.blocked = blocked;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public boolean isPrivate() {
		return isPrivate;
	}

	public void setPrivate(boolean aPrivate) {
		isPrivate = aPrivate;
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
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


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
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


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getProfilePicture() {
		return profilePicture;
	}


	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
	}


	public ProfileType getProfileType() {
		return profileType;
	}


	public void setProfileType(ProfileType profileType) {
		this.profileType = profileType;
	}

	public List<String> getFollowing() {
		return following;
	}

	public void setFollowing(List<String> following) {
		this.following = following;
	}

	public List<String> getFollowRequests() {
		return followRequests;
	}

	public void setFollowRequests(List<String> followRequests) {
		this.followRequests = followRequests;
	}

	public List<String> getBlocked() {
		return blocked;
	}

	public void setBlocked(List<String> blocked) {
		this.blocked = blocked;
	}

	public User(Long id, String username, String password, String firstName, String lastName, String email, String mobile, String gender, String profilePicture, ProfileType profileType, boolean isPrivate, List<String> following, List<String> followRequests, List<String> blocked) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobile = mobile;
		this.gender = gender;
		this.profilePicture = profilePicture;
		this.profileType = profileType;
		this.isPrivate = isPrivate;
		this.following = following;
		this.followRequests = followRequests;
		this.blocked = blocked;
	}
}
