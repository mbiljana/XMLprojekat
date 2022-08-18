package com.example.Agent.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.Agent.model.User;
import com.example.Agent.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final com.example.Agent.repository.UserRepository userRepository;
    @Autowired
    public CustomUserDetailsService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    // Funkcija koja na osnovu username-a iz baze vraca objekat User-a
    @Override
    public UserDetails loadUserByUsername(String korisn) throws UsernameNotFoundException {
        User user = userRepository.findByKorisnicko(korisn);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", korisn));
        } else {
            return user;
        }
    }

}
