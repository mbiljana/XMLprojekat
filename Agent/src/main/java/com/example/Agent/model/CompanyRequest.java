package com.example.Agent.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("companyRequests")
public class CompanyRequest {

	@Id
	private Long id;
	private Company company;//company vec u sebi ima koji je vlasnik, ko trazi zahtev
	
	public CompanyRequest(Long id, Company company) {
		super();
		this.id = id;
		this.company = company;
	}
	public CompanyRequest() {}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	
}
