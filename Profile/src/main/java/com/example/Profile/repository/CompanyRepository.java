package com.example.Profile.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.Profile.model.Company;
import com.example.Profile.model.User;
@Repository
public interface CompanyRepository extends MongoRepository<Company, String> {

	public Company findByName(String name);
}
