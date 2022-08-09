package com.example.connectionsservice.Repository;

import com.example.connectionsservice.Model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<User,Long> {
    public List<User> findByFirstNameAndLastName(String firstName, String lastName);
}
