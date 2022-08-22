package com.example.Profile.dto;

import java.util.List;

import com.example.Profile.model.Language;
import com.example.Profile.model.ProfileType;
import com.example.Profile.model.ProgramLanguage;
import com.example.Profile.model.User;

public class UpdateProfileDTO {
	private Long id;
	private User user;
	private List<ProgramLanguage> proramLanguages;
	private List<String> exCompanies;
	private List<Language> languages;
	private String education;
	private String additionInformation;
	private ProfileType profileType;
	private List<String> supportLanguageList;
	private List<String> supportProgramLanguageList;
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
	public List<String> getSupportLanguageList() {
		return supportLanguageList;
	}
	public void setSupportLanguageList(List<String> supportLanguageList) {
		this.supportLanguageList = supportLanguageList;
	}
	
	public List<String> getSupportProgramLanguageList() {
		return supportProgramLanguageList;
	}
	public void setSupportProgramLanguageList(List<String> supportProgramLanguageList) {
		this.supportProgramLanguageList = supportProgramLanguageList;
	}
	
	public UpdateProfileDTO(Long id, User user, List<ProgramLanguage> proramLanguages, List<String> exCompanies,
			List<Language> languages, String education, String additionInformation, ProfileType profileType,
			List<String> supportLanguageList, List<String> supportProgramLanguageList) {
		super();
		this.id = id;
		this.user = user;
		this.proramLanguages = proramLanguages;
		this.exCompanies = exCompanies;
		this.languages = languages;
		this.education = education;
		this.additionInformation = additionInformation;
		this.profileType = profileType;
		this.supportLanguageList = supportLanguageList;
		this.supportProgramLanguageList = supportProgramLanguageList;
	}
	public UpdateProfileDTO() {}
	

}
