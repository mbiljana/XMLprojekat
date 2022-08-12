package com.example.securityservice.Service;

import com.example.securityservice.Dto.UserRequest;
import com.example.securityservice.Model.User;

import java.util.List;

public interface UserService {
    User findById(Long id);
    User findByUsername(String username);
    List<User> findAll ();
    User save(UserRequest userRequest);
    User saveUser(User user);
}
