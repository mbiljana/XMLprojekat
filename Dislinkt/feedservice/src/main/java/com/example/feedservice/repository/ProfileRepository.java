package com.example.feedservice.repository;

import com.example.feedservice.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile,Long> {
    Profile findByUsername(String username);
}
