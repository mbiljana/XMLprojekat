package com.example.Agent.repository;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.Agent.model.Role;

import java.util.List;

public interface RoleRepository extends MongoRepository<Role,String> {

    List<Role> findByName(String name);
}
