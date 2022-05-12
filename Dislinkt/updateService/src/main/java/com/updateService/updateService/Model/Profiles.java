package com.updateService.updateService.Model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Profiles implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private String emailAddress;
    @Column
    private String phoneNumber;
    @Column
    private Date birthDate; //mozda ne treba
    @Column
    private String username;
    @Column
    private String password;
    @Column
    private String gender;
    @Column
    private String title;
    @Column
    private String biography;
    @Column
    private String workExperience;
    @Column
    private String education;
    @Column
    private String skills;
    @Column
    private String interests;



}
