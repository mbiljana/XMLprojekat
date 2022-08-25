package com.example.securityservice.Repository;


import com.example.securityservice.Model.ImageModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends MongoRepository<ImageModel, Long> {

}
