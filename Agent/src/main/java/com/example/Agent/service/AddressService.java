package com.example.Agent.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Agent.model.Address;
import com.example.Agent.model.Company;
import com.example.Agent.repository.AddressRepository;

@Service
public class AddressService {

	@Autowired
	private AddressRepository addressRepository;
	
	public Address save(Address newaAddress) {
		Long last_id=(long)0;
		List<Address> all=this.addressRepository.findAll();
		for (Address a : all) {
			last_id=a.getId();
		}
		last_id=last_id+1;
		newaAddress.setId(last_id);
		return this.addressRepository.save(newaAddress);
	}
}
