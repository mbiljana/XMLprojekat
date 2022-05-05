package com.example.followservice.service;

import com.example.followservice.model.Profile;

import java.util.List;

public interface ProfileService {
    Profile findOne(Long id);
    List<Profile> findAll();
    Profile getByUsername(String username);
    Profile update(Profile profile) throws Exception;
    Profile create(Profile profile) throws Exception;
}
