package com.example.Profile.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Profile.model.Language;
import com.example.Profile.model.ProgramLanguage;
import com.example.Profile.repository.LanguageRepository;
import com.example.Profile.repository.ProgramLanguageRepository;

@Service
public class LanguageService {
	@Autowired
	private LanguageRepository languageRepository;
	
	public Language save(Language lan) {
		return this.languageRepository.save(lan);
	}
}
