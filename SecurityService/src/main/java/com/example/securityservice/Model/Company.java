package com.example.securityservice.Model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document("comapanies")
public class Company {
    private static final long serialVersionUID = 1L;

    @Id
    private Long id;

    private String korisnicko;
    private String password;
    private String name;
    private String email;
    private String mobile;
    private String profilePicture;

    public Company() {
    }

    public Company(Long id, String korisnicko, String password, String name, String email, String mobile, String profilePicture) {
        this.id = id;
        this.korisnicko = korisnicko;
        this.password = password;
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.profilePicture = profilePicture;
    }
}
