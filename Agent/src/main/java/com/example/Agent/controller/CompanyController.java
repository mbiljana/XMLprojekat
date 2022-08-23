package com.example.Agent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.Agent.dto.CompanyDTO;
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
	}
	
	@RequestMapping(value="api/company/owner/{id}",method = RequestMethod.GET)
	public ResponseEntity<Company>  findOneByOwner(@PathVariable Long id){
		Company company=this.companyService.findByOwnerId(id);
		if (company==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} 
		return new ResponseEntity<>(company, HttpStatus.OK);
	}
}