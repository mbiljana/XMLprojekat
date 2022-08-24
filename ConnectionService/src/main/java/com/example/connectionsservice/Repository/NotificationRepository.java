package com.example.connectionsservice.Repository;

import com.example.connectionsservice.Model.Notification;
import com.example.connectionsservice.Model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface NotificationRepository extends MongoRepository<Notification,Long> {
    List<Notification> findNotificationByUser(User user);
}
