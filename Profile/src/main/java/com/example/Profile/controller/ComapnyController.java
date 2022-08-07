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
	
	@RequestMapping(value="api/company", method = RequestMethod.GET,
			params = "name",
			produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<Company> findByName(@RequestParam String name){
		Company company=this.companyService.findByName(name);
		//CompanyDTO dto=new CompanyDTO(company);
		return new ResponseEntity<>(company,HttpStatus.OK);
	}
}
