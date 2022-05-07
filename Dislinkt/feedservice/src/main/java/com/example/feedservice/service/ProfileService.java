package com.example.feedservice.service;

import com.example.feedservice.model.Profile;

public interface ProfileService {
    Profile findOne(Long id);
    Profile findByUsername(String username);
}
