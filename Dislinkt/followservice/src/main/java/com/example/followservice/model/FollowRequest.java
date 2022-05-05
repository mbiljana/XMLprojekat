package com.example.followservice.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class FollowRequest implements Serializable {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    public Long id;
    @Column
    public Date reqDate;
    @ManyToOne
    Profile profile1;
}
