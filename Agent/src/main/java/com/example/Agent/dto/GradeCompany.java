package com.example.Agent.dto;

import com.example.Agent.model.Company;

public class GradeCompany {

	private Long id;
	private Company company;
	private Integer grade;
	
	public GradeCompany(Long id, Company company, Integer grade) {
		super();
		this.id = id;
		this.company = company;
		this.grade = grade;
	}
	public GradeCompany() {}
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
	public Integer getGrade() {
		return grade;
	}
	public void setGrade(Integer grade) {
		this.grade = grade;
	}
	
	
}
