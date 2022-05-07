package com.registerService.registerservice.Model;


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
public class Korisnik implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
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
    @Column(unique = true)
    private String username;
    @Column
    private String password;
    @Column
    private String gender;


    public Korisnik( String name, String surname, String username, String emailAddress, String phoneNumber, Date birthDate, String gender, String password) {
    }
}

