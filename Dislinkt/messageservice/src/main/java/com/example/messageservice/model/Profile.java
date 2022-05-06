package com.example.messageservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Profile implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @Column
    public String username;
    @ManyToMany
    @JoinTable(name = "chats",
            joinColumns = @JoinColumn(name = "profileId", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "chatId", referencedColumnName = "id"))
    public Set<Chat> chats = new HashSet<>();




}
