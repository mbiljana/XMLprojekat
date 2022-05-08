package com.xmlprojekat.loginservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xmlprojekat.loginservice.model.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
	public Profile findByUsernameAndPassword(String username,String password);
}
