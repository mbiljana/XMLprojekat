package com.example.Agent.mapper;

import com.example.Agent.dto.AddressDTO;
import com.example.Agent.model.Address;

public class AddressMapper {
public AddressMapper() {
		
	}
	public static AddressDTO convertToDTO(Address a) {
		AddressDTO addressDTO=new AddressDTO(
				a.getId(),
				a.getStreet(),
				a.getState(),
				a.getCity()
				);
		return addressDTO;
	}
	
	public static Address convertFromDTO(AddressDTO dto) {
		Address address=new Address(
				dto.getId(),dto.getStreet(),dto.getCity(),dto.getState());
		return address;
	}
}
