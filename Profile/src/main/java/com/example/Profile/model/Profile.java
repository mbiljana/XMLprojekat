package com.example.Profile.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Document("profiles")
public class Profile {
	@Id
	private Long id;
	private User user;
	private List<ProgramLanguage> proramLanguages;
	private List<String> exCompanies;
	private List<Language> languages;
	private String education;
	private String additionInformation;
	
	public Profile(Long id, User user, List<ProgramLanguage> proramLanguages, List<String> exCompanies,
			List<Language> languages, String education, String additionInformation) {
		super();
		this.id = id;
		this.user = user;
		this.proramLanguages = proramLanguages;
		this.exCompanies = exCompanies;
		this.languages = languages;
		this.education = education;
		this.additionInformation = additionInformation;
	}
	
	public Profile() {}
}
