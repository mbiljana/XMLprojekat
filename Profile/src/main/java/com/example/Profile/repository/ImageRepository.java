package com.example.Profile.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.Profile.model.ImageModel;
@Repository
public interface ImageRepository extends MongoRepository<ImageModel, Long> {

}
