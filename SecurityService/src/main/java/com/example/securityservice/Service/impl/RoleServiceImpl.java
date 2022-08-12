package com.example.securityservice.Service.impl;

import com.example.securityservice.Model.Role;
import com.example.securityservice.Repository.RoleRepository;
import com.example.securityservice.Service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository){
        this.roleRepository = roleRepository;
    }

    @Override
    public Role findById(String id) {
        Role auth = this.roleRepository.findById(id).get();
        return auth;
    }

    @Override
    public List<Role> findByName(String name) {
        List<Role> roles = this.roleRepository.findByName(name);
        return roles;
    }

    @Override
    public Role save(Role role) {
        return this.roleRepository.save(role);
    }
}

