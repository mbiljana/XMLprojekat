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
@AllArgsConstructor
@NoArgsConstructor
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
    private List<String> following;
    //follow request from other users
    private List<String> followRequests;

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
}
