package com.example.securityservice.Dto;

//dto za login
public class JwtAuthenticationRequest {
    private String korisnicko;
    private String password;


    public JwtAuthenticationRequest() {
        super();
    }

    public JwtAuthenticationRequest(String username, String password) {
        this.setUsername(username);
        this.setPassword(password);
    }

    public String getUsername() {
        return this.korisnicko;
    }

    public void setUsername(String username) {
        this.korisnicko = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
