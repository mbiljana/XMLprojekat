package com.registerService.registerservice.Model.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class KorisnikDTO {
    private Long id;
    private String name;
    private String surname;
    private String emailAddress;
    private String phoneNumber;
    private Date birthDate;
    private String username;
    private String password;
    private String gender;


    public KorisnikDTO( String name, String surname, String emailAddress, String phoneNumber, Date birthDate, String username, String password, String gender) {
        this.name = name;
        this.surname = surname;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
        this.username = username;
        this.password = password;
        this.gender = gender;
    }
}
