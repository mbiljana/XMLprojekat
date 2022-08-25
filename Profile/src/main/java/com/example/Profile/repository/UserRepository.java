package com.example.Profile.repository;

import java.util.List;

import com.example.Profile.model.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.Profile.model.User;
@Repository
public interface UserRepository extends MongoRepository<User, Long> {

	 List<User> findByFirstNameAndLastName(String firstName, String lastName);

	 //@Query(value ="{'username : ?0'}")
	 User findByUsername(String username);
	 User getById(Long id);
	 List<User> findAll();
}
