package com.example.securityservice.Service;

import com.example.securityservice.Model.Role;

import java.util.List;

public interface RoleService {
    Role findById(Long id);
    List<Role> findByName(String name);
    Role save(Role role);
}
