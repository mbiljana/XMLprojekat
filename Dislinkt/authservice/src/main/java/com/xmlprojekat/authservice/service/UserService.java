package com.xmlprojekat.authservice.service;

import java.util.List;

import com.xmlprojekat.authservice.dto.UserRequest;
import com.xmlprojekat.authservice.model.User;

public interface UserService {
    User findById(Long id);
    User findByUsername(String username);
    List<User> findAll ();
	User save(UserRequest userRequest);
}