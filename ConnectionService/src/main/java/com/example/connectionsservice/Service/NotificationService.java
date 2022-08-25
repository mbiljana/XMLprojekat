package com.example.connectionsservice.Service;

import com.example.connectionsservice.Model.Notification;
import com.example.connectionsservice.Repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    private final NotificationRepository notificationRepository;

    @Autowired
    public NotificationService(NotificationRepository notificationRepository){
        this.notificationRepository = notificationRepository;
    }
    public Notification save(Notification notification){
        return this.notificationRepository.save(notification);
    }
}
