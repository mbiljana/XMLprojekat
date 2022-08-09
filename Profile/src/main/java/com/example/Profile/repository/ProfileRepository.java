package com.example.Profile.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.Profile.model.Profile;
@Repository
public interface ProfileRepository extends MongoRepository<Profile, Long>{

}
