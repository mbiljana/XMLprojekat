package com.example.Agent.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.Agent.model.ImageModel;

@Repository
public interface ImageRepository extends MongoRepository<ImageModel, Long> {

}
