package com.example.Profile.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Profile.model.ProgramLanguage;
import com.example.Profile.repository.ProgramLanguageRepository;

@Service
public class ProgramLanguageService {

	@Autowired
	private ProgramLanguageRepository programLanguageRepository;
	
	public ProgramLanguage save(ProgramLanguage lan) {
		Long last_id=(long)0;
		List<ProgramLanguage> all=this.programLanguageRepository.findAll();
		for (ProgramLanguage programLanguage : all) {
			last_id=programLanguage.getId();
		}
		last_id=last_id+1;
		lan.setId(last_id);
		return this.programLanguageRepository.save(lan);
	}
	public ProgramLanguage findByIdProgramLanguage(Long id) {
		Optional<ProgramLanguage> opt=this.programLanguageRepository.findById(id);
		if(!opt.isPresent()) {
			return null;
		}
		return opt.get();
	}
}
