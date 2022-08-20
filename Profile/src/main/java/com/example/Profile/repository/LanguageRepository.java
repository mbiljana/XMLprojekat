package com.example.Profile.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.Profile.model.Language;

@Repository
public interface LanguageRepository extends MongoRepository<Language, Long>{
	Language findByName(String name);
}
