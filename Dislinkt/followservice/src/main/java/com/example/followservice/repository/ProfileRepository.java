package com.example.followservice.repository;

import com.example.followservice.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile,Long> {
    Profile findByUsername(String username);
}
