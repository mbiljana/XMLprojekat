package com.example.Profile.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Profile.model.Company;
import com.example.Profile.model.User;
import com.example.Profile.repository.CompanyRepository;

@Service
public class CompanyService {

	@Autowired
	private CompanyRepository companyRepository;
	
	public Company findByName(String name) {
		return this.companyRepository.findByName(name);
	}
	public Company save(Company company) {
		return this.companyRepository.save(company);
	}
}
