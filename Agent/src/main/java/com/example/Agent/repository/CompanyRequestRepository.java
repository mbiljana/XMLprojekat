package com.example.Agent.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.Agent.model.CompanyRequest;

@Repository
public interface CompanyRequestRepository extends MongoRepository<CompanyRequest, Long>{

}
