package com.example.connectionsservice.Repository;

import com.example.connectionsservice.Model.Message;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MessageRepository extends MongoRepository<Message,Long> {
    List<Message> findMessageByRecieverUsername(String username);
    List<Message> findMessageBySenderUsername(String username);
}
