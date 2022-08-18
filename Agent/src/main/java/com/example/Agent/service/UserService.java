package com.example.Agent.service;


import java.util.List;

import com.example.Agent.dto.UserRequest;
import com.example.Agent.model.User;

public interface UserService {
    User findById(Long id);
    User findByKorisnicko(String korisnicko);
    List<User> findAll ();
    User save(UserRequest userRequest);
    User saveUser(User user);
}
