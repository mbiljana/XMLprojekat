package com.example.Agent.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.Agent.dto.CompanyUpdateDTO;
import com.example.Agent.dto.UpdateUserDTO;
import com.example.Agent.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Agent.model.Company;
import com.example.Agent.model.CompanyRequest;
import com.example.Agent.model.Post;
import com.example.Agent.repository.CompanyRepository;

@Service
public class CompanyService {

	@Autowired
	private CompanyRepository companyRepository;
	
	@Autowired
	private AddressService addressService;
	
	public Company findByNameIgnoreCase(String name) {
		return this.companyRepository.findByNameIgnoreCase(name);
	}
	
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
	public Company saveUpdate (Company newCompany) {
		
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

	/*
	public Company findById(Long id){

		return this.companyRepository.findById(id).get();
	}
	 */


	public Company update(CompanyUpdateDTO editedCompany) {
		Company company = this.findById(editedCompany.getId());
		company.setAddress(editedCompany.getAddress());
		company.setDescription(editedCompany.getDescription());
		company.setMobile(editedCompany.getMobile());
		company.setEmail(editedCompany.getEmail());
		company.setUsername(editedCompany.getUsername());
		company.setName(editedCompany.getName());
		if (company == null) {
			throw new IllegalStateException("User does not exist!");
		} else {
			return companyRepository.save(company);
		}
	}
	public Company findById(Long id) {
		Optional<Company> opt=this.companyRepository.findById(id);
		if(!opt.isPresent()) {
			return null;
		}
		return opt.get();

	}
}
