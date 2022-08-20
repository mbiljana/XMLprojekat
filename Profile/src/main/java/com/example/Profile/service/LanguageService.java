package com.example.Profile.service;

import java.util.List;
import java.util.Optional;

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
	
	
	public Language save(Language  lan) {
		Long last_id=(long)0;
		List<Language > all=this.languageRepository.findAll();
		for (Language  language : all) {
			last_id=language.getId();
		}
		last_id=last_id+1;
		lan.setId(last_id);
		return this.languageRepository.save(lan);
	}
	public Language findById(Long id) {
		Optional<Language> opt=this.languageRepository.findById(id);
		if(!opt.isPresent()) {
			return null;
		}
		return opt.get();
	}
	public Language findByName(String name) {
		return this.languageRepository.findByName(name);
	}
}
