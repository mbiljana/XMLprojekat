package com.xmlprojekat.postservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xmlprojekat.postservice.model.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
