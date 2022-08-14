package com.example.Profile.repository;

import com.example.Profile.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.Profile.model.Profile;

import java.util.List;

@Repository
public interface ProfileRepository extends MongoRepository<Profile, Long>{
    public Profile getById(Long id);
    public List<Profile> findAll();

}
