package com.example.Agent.controller;

import java.util.List;

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
import com.example.Agent.repository.CompanyRequestRepository;
import com.example.Agent.repository.UserRepository;
import com.example.Agent.service.CompanyRequestService;
import com.example.Agent.service.CompanyService;
import com.example.Agent.service.UserService;

@CrossOrigin("*")
@RestController
public class CompanyRequestController {
	@Autowired
	private CompanyRequestService companyRequestService;
	
	@Autowired
	private CompanyRequestRepository companyRequestRepository;
	@Autowired
	private CompanyService companyService;
	@Autowired 
	private UserRepository userRepository;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="api/companyRequest",method = RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CompanyRequest> save(@RequestBody CompanyRequest newrequest){
		CompanyRequest companyRequest = this.companyRequestService.save(newrequest);
		return new ResponseEntity<>(companyRequest,HttpStatus.CREATED);
	}
	@RequestMapping(value="api/companyRequest/approve",method = RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CompanyRequest> approve(@RequestBody CompanyRequest newrequest){
		newrequest.getCompany().getOwner().setRoleType("Owner");
		userService.saveUser(newrequest.getCompany().getOwner());
		Company saved=this.companyService.save(newrequest.getCompany());
		newrequest.setCompany(saved);
		CompanyRequest companyRequest = this.companyRequestRepository.save(newrequest);
		return new ResponseEntity<>(companyRequest,HttpStatus.CREATED);
	}
	@RequestMapping(value="api/companyRequest", method = RequestMethod.GET,
			produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<List<CompanyRequest>> findAll(){
		List<CompanyRequest> all=this.companyRequestService.findAll();
		return new ResponseEntity<List<CompanyRequest>>(all, HttpStatus.OK);
	}
	@RequestMapping(value="api/companyRequest/{id}",method = RequestMethod.GET)
	public ResponseEntity<CompanyRequest>  findOne(@PathVariable Long id){
		CompanyRequest req=this.companyRequestService.findById(id);
		if (req==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} 
		return new ResponseEntity<>(req, HttpStatus.OK);
	}
}
