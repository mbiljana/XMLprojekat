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
	private ProfileType profileType;


	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	public List<ProgramLanguage> getProramLanguages() {
		return proramLanguages;
	}



	public void setProramLanguages(List<ProgramLanguage> proramLanguages) {
		this.proramLanguages = proramLanguages;
	}



	public List<String> getExCompanies() {
		return exCompanies;
	}



	public void setExCompanies(List<String> exCompanies) {
		this.exCompanies = exCompanies;
	}



	public List<Language> getLanguages() {
		return languages;
	}



	public void setLanguages(List<Language> languages) {
		this.languages = languages;
	}



	public String getEducation() {
		return education;
	}



	public void setEducation(String education) {
		this.education = education;
	}



	public String getAdditionInformation() {
		return additionInformation;
	}



	public void setAdditionInformation(String additionInformation) {
		this.additionInformation = additionInformation;
	}



	public ProfileType getProfileType() {
		return profileType;
	}



	public void setProfileType(ProfileType profileType) {
		this.profileType = profileType;
	}



	public Profile(Long id, User user, List<ProgramLanguage> proramLanguages, List<String> exCompanies,
			List<Language> languages, String education, String additionInformation, ProfileType profileType) {
		super();
		this.id = id;
		this.user = user;
		this.proramLanguages = proramLanguages;
		this.exCompanies = exCompanies;
		this.languages = languages;
		this.education = education;
		this.additionInformation = additionInformation;
		this.profileType = profileType;
	}


	public Profile() {}
}
