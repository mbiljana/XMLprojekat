package com.example.Agent.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Agent.model.Company;
import com.example.Agent.model.CompanyRequest;
import com.example.Agent.repository.CompanyRepository;

@Service
public class CompanyService {

	@Autowired
	private CompanyRepository companyRepository;
	
	@Autowired
	private AddressService addressService;
	
	
	public Company save (Company newCompany) {
		Long last_id=(long)0;
		List<Company> all=this.companyRepository.findAll();
		for (Company company : all) {
			last_id=company.getId();
		}
		last_id=last_id+1;
		newCompany.setId(last_id);
		this.addressService.save(newCompany.getAddress());
		return this.companyRepository.save(newCompany);
	}
	public Company findByOwnerId(Long id) {
		List<Company> all=this.companyRepository.findAll();
		for (Company company : all) {
			if(company.getOwner().getId()==id) {
				return company;
			}
		}
		return null;
	}
}
