package com.example.Profile.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.Profile.model.ProgramLanguage;

@Repository
public interface ProgramLanguageRepository extends MongoRepository<ProgramLanguage, Long>{

}
