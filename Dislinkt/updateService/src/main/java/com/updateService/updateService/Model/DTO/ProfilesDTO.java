package com.updateService.updateService.Model.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProfilesDTO {

    private Long id;
    private String name;
    private String surname;
    private String emailAddress;
    private String phoneNumber;
    private Date birthDate; //mozda ne treba
    private String username;
    private String password;
    private String gender;
    private String title;
    private String biography;
    private String workExperience;
    private String education;
    private String skills;
    private String interests;


    public ProfilesDTO(Date birthDate, String name, String surname, String emailAddress, String phoneNumber, String password, String gender, String username, String biography, String title, String education, String workExperience, String skills, String interests) {
    }
}
