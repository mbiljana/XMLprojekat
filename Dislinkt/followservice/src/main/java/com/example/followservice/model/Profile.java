package com.example.followservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Profile implements Serializable {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    public Long id;
    @Column
    public String username;
    @Column
    public boolean isPublic;
    @Column
    public boolean isBlocked;
    @OneToMany(mappedBy = "profile1",cascade = CascadeType.ALL,orphanRemoval = true)
    public List<FollowRequest> followRequests = new ArrayList<FollowRequest>();
    @OneToMany(mappedBy = "profile2",cascade = CascadeType.ALL,orphanRemoval = true)
    public List<Connection> connections = new ArrayList<>();

    public Profile(Long id, String username, boolean isPublic, boolean isBlocked) {
        this.id = id;
        this.username = username;
        this.isPublic = isPublic;
        this.isBlocked = isBlocked;
    }
}
