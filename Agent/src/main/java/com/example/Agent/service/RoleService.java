package com.example.Agent.service;
import java.util.List;

import com.example.Agent.model.Role;

public interface RoleService {
    Role findById(String id);
    List<Role> findByName(String name);
    Role save(Role role);
}
