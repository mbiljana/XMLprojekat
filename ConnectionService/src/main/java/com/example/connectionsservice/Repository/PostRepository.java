package com.example.connectionsservice.Repository;

import com.example.connectionsservice.Model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post,Long> {
}
