package com.example.messageservice.service;

import com.example.messageservice.model.Profile;

import java.util.List;

public interface ProfileService {
    Profile findOne(Long id);
    List<Profile> findAll();
    Profile findByUsername(String username);
    Profile create(Profile profile) throws Exception;
    Profile update(Profile profile) throws Exception;
    void delete(Long id);
}
