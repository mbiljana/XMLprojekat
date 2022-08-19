package com.example.Agent.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.Agent.model.User;


public interface UserRepository extends MongoRepository<User,Long> {
    User findByKorisnicko(String username);
}
