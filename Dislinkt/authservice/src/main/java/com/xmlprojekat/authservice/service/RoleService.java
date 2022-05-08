package com.xmlprojekat.authservice.service;

import java.util.List;

import com.xmlprojekat.authservice.model.Role;


public interface RoleService {
	Role findById(Long id);
	List<Role> findByName(String name);
}
