package com.example.Profile.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Profile.model.ProgramLanguage;
import com.example.Profile.repository.ProgramLanguageRepository;

@Service
public class ProgramLanguageService {

	@Autowired
	private ProgramLanguageRepository programLanguageRepository;
	
	public ProgramLanguage save(ProgramLanguage lan) {
		return this.programLanguageRepository.save(lan);
	}
}
