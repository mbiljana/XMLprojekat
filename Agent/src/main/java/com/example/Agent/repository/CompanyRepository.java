package com.example.Agent.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.Agent.model.Company;

@Repository
public interface CompanyRepository extends MongoRepository<Company, Long>{

}
