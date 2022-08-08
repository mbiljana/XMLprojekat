package com.xmlprojekat.authservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xmlprojekat.authservice.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}