package com.example.followservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Connection implements Serializable {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    public Long id;
    @ManyToOne
    Profile profile2;
}
