package com.example.securityservice.Repository;

import com.example.securityservice.Model.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RoleRepository extends MongoRepository<Role,String> {

    List<Role> findByName(String name);
}
