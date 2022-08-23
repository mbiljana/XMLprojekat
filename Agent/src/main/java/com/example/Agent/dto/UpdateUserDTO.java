package com.example.Agent.dto;

public class UpdateUserDTO {
    private Long id;

    private String korisnicko;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String mobile;
    private String profilePicture;

    public UpdateUserDTO() {
    }

    public UpdateUserDTO(Long id, String korisnicko, String password, String firstName, String lastName, String email, String mobile, String profilePicture) {
        this.id = id;
        this.korisnicko = korisnicko;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.mobile = mobile;
        this.profilePicture = profilePicture;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKorisnicko() {
        return korisnicko;
    }

    public void setKorisnicko(String korisnicko) {
        this.korisnicko = korisnicko;
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

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }
}
