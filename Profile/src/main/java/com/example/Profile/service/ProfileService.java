package com.example.Profile.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.Profile.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.Profile.dto.UpdateProfileDTO;
import com.example.Profile.model.Language;
import com.example.Profile.model.Profile;
import com.example.Profile.model.ProgramLanguage;
import com.example.Profile.model.User;
import com.example.Profile.repository.ProfileRepository;

@Service
public class ProfileService {

	@Autowired
	private ProfileRepository profileRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserService userService;
	@Autowired
	private LanguageService languageService;
	@Autowired
	private ProgramLanguageService programLanguageService;
	
	
	public Profile save(Profile profile) {
		return this.profileRepository.save(profile);
	}
	public Profile saveUser(User user){
		/*
		Long last_id=(long)0;
		List<Profile> allUsers = this.profileRepository.findAll();
		for(Profile us : allUsers){
			last_id  =us.getId();
		}
		last_id = last_id+1;

		 */
		Profile profile = new Profile();
		profile.setUser(user);
		profile.setId(user.getId());
		//ovo se dodaje da liste ne bi bile null, pa da bi se mogao raditi update
		profile.setExCompanies(new ArrayList<>());
		profile.setLanguages(new ArrayList<>());
		profile.setProramLanguages(new ArrayList<>());
		
		return this.profileRepository.save(profile);
	}


	public Profile findById(Long id) {
		Optional<Profile> profileOpt = this.profileRepository.findById(id);
		if (!profileOpt.isPresent()) {
			return null;
		} else
		{
			return profileOpt.get();
		}
		
	}
	public List<Profile> findAll(){
		return profileRepository.findAll();
	}



	public Profile update(Profile editedUser){
		Profile existingUser = this.findById(editedUser.getId());
		if(existingUser == null){
			throw new IllegalStateException("User does not exist!");
		}
		else{
			User u = this.userService.update(editedUser.getUser());

			return profileRepository.save(editedUser);
		}
	}
	public Profile updateProfileLists(UpdateProfileDTO updateProfile) {
		Profile p=this.findById(updateProfile.getId());
		p.setAdditionInformation(updateProfile.getAdditionInformation());
		p.setEducation(updateProfile.getEducation());
		p.setProfileType(updateProfile.getProfileType());
		p.setUser(updateProfile.getUser());
		p.setExCompanies(updateProfile.getExCompanies());
		List<String> lll=updateProfile.getSupportLanguageList();
		/*if(!(p.getLanguages()==null)) {
			p.getLanguages().clear();
		}
		if(!(p.getProramLanguages()==null)) {
			p.getProramLanguages().clear();
		}*/
		p.setLanguages(new ArrayList<>());
		p.setProramLanguages(new ArrayList<>());
		for (String l : lll) {
			Language newLan=this.languageService.findByName(l);
			if(newLan==null) {
				Language addNew=new Language((long)0, l);
				this.languageService.save(addNew);
				p.getLanguages().add(addNew);
			}else {
				p.getLanguages().add(newLan);
			}
			
		}
		List<String> ppp=updateProfile.getSupportProgramLanguageList();
		for (String pp : ppp) {
			ProgramLanguage newLan=this.programLanguageService.findByName(pp);
			if(newLan==null) {
				ProgramLanguage addNew=new ProgramLanguage((long)0, pp);
				this.programLanguageService.save(addNew);
				p.getProramLanguages().add(addNew);
			}else {
				p.getProramLanguages().add(newLan);
			}
		}
		return this.update(p);
	}

}
