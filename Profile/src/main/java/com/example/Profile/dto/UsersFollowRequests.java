package com.example.Profile.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//@AllArgsConstructor
//@NoArgsConstructor
public class UsersFollowRequests {
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public UsersFollowRequests(String username) {
        super();
        this.username = username;
    }
    public UsersFollowRequests() {}

}
