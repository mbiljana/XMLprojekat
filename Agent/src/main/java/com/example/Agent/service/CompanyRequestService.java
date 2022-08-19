package com.example.Agent.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Agent.model.CompanyRequest;
import com.example.Agent.repository.CompanyRequestRepository;

@Service
public class CompanyRequestService {

	@Autowired
	CompanyRequestRepository companyRequestRepository;
	
	public CompanyRequest save(CompanyRequest newCompanyRequest) {
		List<CompanyRequest> all=this.companyRequestRepository.findAll();
		Long last_id=(long)0;
		for (CompanyRequest companyRequest : all) {
			last_id=companyRequest.getId();
		}
		last_id=last_id+1;
		newCompanyRequest.setId(last_id);
		return this.companyRequestRepository.save(newCompanyRequest);
	}
	public List<CompanyRequest> findAll(){
		return this.companyRequestRepository.findAll();
	}
}
