package com.example.connectionsservice.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Getter
@Setter
//@AllArgsConstructor
//@NoArgsConstructor
@Document("users")

public class User {
    @Id
    private Long id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String mobile;
    private String gender;
    private String profilePicture;
    //is the profile private(true) or public(false)
    private boolean isPrivate;
    //accounts this user follows
    private List<String> following;//lista username-va
    //follow request from other users
    private List<String> followRequests;
    private List<Message> sentMessages;
    private List<Message> recievedMessages;

	private List<String> blocked;

    private List<Notification> messagesNotifications;
	private List<Notification> postNotifications;


    public User(Long id, String username, String password, String firstName, String lastName, String email, String mobile, String gender, String profilePicture, boolean isPrivate) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.mobile = mobile;
        this.gender = gender;
        this.profilePicture = profilePicture;
        this.isPrivate = isPrivate;
    }

	public User(Long id, String username, String password, String firstName, String lastName, String email, String mobile, String gender, String profilePicture, boolean isPrivate, List<String> following, List<String> followRequests, List<Message> sentMessages, List<Message> recievedMessages, List<String> blocked, List<Notification> messagesNotifications) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobile = mobile;
		this.gender = gender;
		this.profilePicture = profilePicture;
		this.isPrivate = isPrivate;
		this.following = following;
		this.followRequests = followRequests;
		this.sentMessages = sentMessages;
		this.recievedMessages = recievedMessages;
		this.blocked = blocked;
		this.messagesNotifications = messagesNotifications;
	}

	public User(Long id, String username, String password, String firstName, String lastName, String email,
				String mobile, String gender, String profilePicture, boolean isPrivate, List<String> following,
				List<String> followRequests, List<Message> sentMessages, List<Message> recievedMessages) {
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
		this.isPrivate = isPrivate;
		this.following = following;
		this.followRequests = followRequests;
		this.sentMessages = sentMessages;
		this.recievedMessages = recievedMessages;

	}


	public User(Long id, String username, String password, String firstName, String lastName, String email, String mobile, String gender, String profilePicture, boolean isPrivate, List<String> following, List<String> followRequests) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.mobile = mobile;
        this.gender = gender;
        this.profilePicture = profilePicture;
        this.isPrivate = isPrivate;
        this.following = following;
    }


	public User(Long id, String username, String password, String firstName, String lastName, String email, String mobile, String gender, String profilePicture, boolean isPrivate, List<String> following, List<String> followRequests, List<Message> sentMessages, List<Message> recievedMessages, List<String> blocked) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobile = mobile;
		this.gender = gender;
		this.profilePicture = profilePicture;
		this.isPrivate = isPrivate;
		this.following = following;
		this.followRequests = followRequests;
		this.sentMessages = sentMessages;
		this.recievedMessages = recievedMessages;
		this.blocked = blocked;
	}

	public User(Long id, String username, String password, String firstName, String lastName, String email, String mobile, String gender, String profilePicture, boolean isPrivate, List<String> following, List<String> followRequests, List<Message> sentMessages, List<Message> recievedMessages, List<String> blocked, List<Notification> messagesNotifications, List<Notification> postNotifications) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobile = mobile;
		this.gender = gender;
		this.profilePicture = profilePicture;
		this.isPrivate = isPrivate;
		this.following = following;
		this.followRequests = followRequests;
		this.sentMessages = sentMessages;
		this.recievedMessages = recievedMessages;
		this.blocked = blocked;
		this.messagesNotifications = messagesNotifications;
		this.postNotifications = postNotifications;
	}

	public List<String> getBlocked() {
		return blocked;
	}

	public void setBlocked(List<String> blocked) {
		this.blocked = blocked;
	}


	public User() {}



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

	public boolean isPrivate() {
		return isPrivate;
	}

	public void setPrivate(boolean isPrivate) {
		this.isPrivate = isPrivate;
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

	public List<Message> getSentMessages() {
		return sentMessages;
	}

	public void setSentMessages(List<Message> sentMessages) {
		this.sentMessages = sentMessages;
	}

	public List<Message> getRecievedMessages() {
		return recievedMessages;
	}

	public void setRecievedMessages(List<Message> recievedMessages) {
		this.recievedMessages = recievedMessages;
	}

	public List<Notification> getMessagesNotifications() {
		return messagesNotifications;
	}

	public void setMessagesNotifications(List<Notification> messagesNotifications) {
		this.messagesNotifications = messagesNotifications;
	}

	public List<Notification> getPostNotifications() {
		return postNotifications;
	}

	public void setPostNotifications(List<Notification> postNotifications) {
		this.postNotifications = postNotifications;
	}
	
}
