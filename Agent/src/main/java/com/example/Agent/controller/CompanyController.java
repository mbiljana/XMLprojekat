package com.example.Agent.controller;

import com.example.Agent.dto.CompanyUpdateDTO;
import com.example.Agent.dto.UpdateUserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.example.Agent.dto.CompanyDTO;
import com.example.Agent.dto.GradeCompany;
import com.example.Agent.mapper.CompanyMapper;
import com.example.Agent.model.Company;
import com.example.Agent.model.CompanyRequest;
import com.example.Agent.model.User;
import com.example.Agent.repository.UserRepository;
import com.example.Agent.service.CompanyService;
import com.example.Agent.service.UserService;


@CrossOrigin("*")
@RestController
public class CompanyController {
	@Autowired
	private CompanyService companyService;
	
	
	@RequestMapping(value="api/company",method = RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CompanyDTO> save(@RequestBody CompanyDTO newCompanyDTO){
		Company company = CompanyMapper.convertFromDTO(newCompanyDTO);
		Company saved=this.companyService.save(company);
		CompanyDTO dto=CompanyMapper.convertToDTO(saved);
		return new ResponseEntity<>(dto,HttpStatus.CREATED);
	}/*
	@RequestMapping(value="api/company",method = RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Company> save(@RequestBody Company newCompany){
		Company saved=this.companyService.save(newCompany);
		return new ResponseEntity<>(saved,HttpStatus.CREATED);
	}*/
	
	@RequestMapping(value="api/company/owner/{id}",method = RequestMethod.GET)
	public ResponseEntity<Company>  findOneByOwner(@PathVariable Long id){
		Company company=this.companyService.findByOwnerId(id);
		if (company==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} 
		return new ResponseEntity<>(company, HttpStatus.OK);
	}


	//update company profile
	@PutMapping(value = "company/update",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> updateProfile(@RequestBody CompanyUpdateDTO uDTO) throws Exception {

		return new ResponseEntity<Company>(this.companyService.update(uDTO),HttpStatus.OK);

	@RequestMapping(value="api/company/{id}",method = RequestMethod.GET)
	public ResponseEntity<Company>  findById(@PathVariable Long id){
		Company company=this.companyService.findById(id);
		if (company==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} 
		return new ResponseEntity<>(company, HttpStatus.OK);
	}
	@RequestMapping(value="api/company", method = RequestMethod.GET,
			params = "name",
			produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<Company> findByName(@RequestParam String name){
		Company company=this.companyService.findByNameIgnoreCase(name);
		return new ResponseEntity<>(company,HttpStatus.OK);
	}
	@RequestMapping(value="api/company/grade",method = RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Company> grade(@RequestBody GradeCompany newGradeCompany){
		Company com=this.companyService.findById(newGradeCompany.getCompany().getId());
		com.getGrades().add(newGradeCompany.getGrade());
		Company saved=this.companyService.saveUpdate(com);
		return new ResponseEntity<>(saved,HttpStatus.CREATED);
	}
	@RequestMapping(value="api/company/salary",method = RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Company> salary(@RequestBody GradeCompany newGradeCompany){
		Company com=this.companyService.findById(newGradeCompany.getCompany().getId());
		com.getSalaries().add(newGradeCompany.getGrade());
		Company saved=this.companyService.saveUpdate(com);
		return new ResponseEntity<>(saved,HttpStatus.CREATED);

	}
}
