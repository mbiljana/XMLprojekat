package com.example.Agent.mapper;

import com.example.Agent.dto.AddressDTO;
import com.example.Agent.dto.CompanyDTO;
import com.example.Agent.dto.PostDTO;
import com.example.Agent.model.Address;
import com.example.Agent.model.Company;
import com.example.Agent.model.Post;

public class PostMapper {
	public PostMapper() {
			
		}
		public static PostDTO convertToDTO(Post a) {
			CompanyDTO companyDTO=CompanyMapper.convertToDTO(a.getCompany());
			PostDTO postDTO=new PostDTO(
					a.getId(),
					a.getTitle(),
					a.getJobDescription(),
					a.getPreconditions(),
					a.getPosition(),
					a.getPicture(),
					a.getNumOfLikes(),
					a.getNumOfDislikes(),
					companyDTO
					);
			return postDTO;
		}
		
		public static Post convertFromDTO(PostDTO dto) {
			Address address=new Address(dto.getCompany().getAddress().getId(),dto.getCompany().getAddress().getStreet(), dto.getCompany().getAddress().getState(),dto.getCompany().getAddress().getCity());
			Company company=new Company(dto.getCompany().getId(),dto.getCompany().getName(), dto.getCompany().getDescription(), address,dto.getCompany().getUsername(),dto.getCompany().getEmail(),dto.getCompany().getMobile(),dto.getCompany().getProfilePicture(),dto.getCompany().getOwner());
			Post post=new Post(
					dto.getId(),dto.getTitle(),dto.getJobDescription(),dto.getPreconditions(),dto.getPosition(),dto.getPicture(),dto.getNumOfLikes(),dto.getNumOfDislikes(),company);
			return post;
		}
}
