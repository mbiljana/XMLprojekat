package com.example.Profile.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Profile.dto.CompanyDTO;
import com.example.Profile.model.Company;
import com.example.Profile.service.CompanyService;
@CrossOrigin("*")
@RestController
public class ComapnyController {
	@Autowired
	private CompanyService companyService;
	
	@RequestMapping(value="api/company/insert",method = RequestMethod.GET,produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<Void> insert(){
		this.companyService.save(new Company((long) 1, "m&i", "123","M&I", "m&i@gmail.com", "83498234923", "/assets/companyPicture/company1.jpeg"));
		this.companyService.save(new Company((long)2, "symhony", "123","Symhony", "symhony@gmail.com", "83498234923", "/assets/companyPicture/company2.jpeg"));
		this.companyService.save(new Company((long)3, "synehrone", "123","Synehrone", "synehrone@gmail.com", "83498234923", "/assets/companyPicture/company3.jpeg"));
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	@RequestMapping(value="api/company", method = RequestMethod.GET,
			params = "name",
			produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<Company> findByName(@RequestParam String name){
		Company company=this.companyService.findByName(name);
		//CompanyDTO dto=new CompanyDTO(company);
		return new ResponseEntity<>(company,HttpStatus.OK);
	}
}
