package com.example.Profile.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("profiles")
public class Profile {
	@Id
	private String id;
	private User user;
	
}
