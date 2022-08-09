package com.example.Profile.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
@Document("programLanguages")
public class ProgramLanguage {

	@Id
	private Long id;
	private String name;
	
	public ProgramLanguage() {}

	public ProgramLanguage(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
}
