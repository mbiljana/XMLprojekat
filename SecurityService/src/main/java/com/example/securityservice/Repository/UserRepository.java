package com.example.securityservice.Repository;

import com.example.securityservice.Model.User;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface UserRepository extends MongoRepository<User,Long> {
    User findByKorisnicko(String username);
}
