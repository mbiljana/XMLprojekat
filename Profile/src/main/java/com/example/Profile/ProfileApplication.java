package com.example.Profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.example.Profile.model.User;
import com.example.Profile.repository.UserRepository;

@SpringBootApplication
@EnableMongoRepositories
public class ProfileApplication {
	public static void main(String[] args) {
		SpringApplication.run(ProfileApplication.class, args);
	}


}
