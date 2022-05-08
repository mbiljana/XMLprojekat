package com.updateService.updateService.Service;

import com.updateService.updateService.Model.Profiles;

import java.util.List;

public interface ProfilesService {
    Profiles findOne(Long id);
    List<Profiles> findAll();
    Profiles getByUsername(String username);
    Profiles update(Profiles newProfile) throws Exception;
    Profiles save(Profiles newProfile) throws Exception;
    Profiles create(Profiles profile) throws Exception;

}