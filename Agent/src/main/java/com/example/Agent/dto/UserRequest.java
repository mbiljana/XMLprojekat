package com.example.Agent.dto;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

//DTO koji preuzima podatke sa forme za registraciju
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
    private Long id;

    private String korisnicko;

    private String password;

    private String firstName;

    private String lastName;

    private String email;
    private String mobile;
    private String profilePicture;

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getKorisnicko() {
        return korisnicko;
    }

    public void setKorisnicko(String username) {
        this.korisnicko = username;
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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
