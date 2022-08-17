package com.example.Agent.mapper;

import com.example.Agent.dto.AddressDTO;
import com.example.Agent.dto.CompanyDTO;
import com.example.Agent.model.Address;
import com.example.Agent.model.Company;

public class CompanyMapper {
	public CompanyMapper() {
		
	}
	public static CompanyDTO convertToDTO(Company a) {
		AddressDTO addressDTO=AddressMapper.convertToDTO(a.getAddress());
		CompanyDTO comanyDTO=new CompanyDTO(
				a.getId(),
				a.getName(),
				a.getDescription(),
				addressDTO,
				a.getUsername(),
				a.getPassword(),
				a.getEmail(),
				a.getMobile(),
				a.getProfilePicture()
				);
		return comanyDTO;
	}
	
	public static Company convertFromDTO(CompanyDTO dto) {
		Address address=new Address(dto.getAddress().getId(),dto.getAddress().getStreet(), dto.getAddress().getState(), dto.getAddress().getCity());
		Company company=new Company(
				dto.getId(),dto.getName(),dto.getDescription(),address,dto.getUsername(),dto.getPassword(),dto.getEmail(),dto.getMobile(),dto.getProfilePicture());
		return company;
	}
}
