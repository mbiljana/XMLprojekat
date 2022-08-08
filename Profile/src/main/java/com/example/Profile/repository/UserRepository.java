package com.example.Profile.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.Profile.model.User;
@Repository
public interface UserRepository extends MongoRepository<User, Long> {

	public List<User> findByFirstNameAndLastName(String firstName, String lastName);
}
