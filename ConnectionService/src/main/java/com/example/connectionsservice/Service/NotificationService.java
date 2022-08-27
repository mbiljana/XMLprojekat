package com.example.connectionsservice.Service;

import com.example.connectionsservice.Model.Notification;
import com.example.connectionsservice.Repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public Notification saveNotif(Notification notif){
        Notification n = new Notification();
        Long last_id=(long)0;
        List<Notification> allNotifs = this.notificationRepository.findAll();
        for(Notification us : allNotifs){
            last_id  =us.getId();
        }
        last_id = last_id+1;
        n.setId(last_id);
        n.setDate(notif.getDate());
        n.setMessageNotif(notif.getMessageNotif());
        n.setUser(notif.getUser());
        return this.notificationRepository.save(n);
    }

    public Notification findOne(Long id){
        return this.notificationRepository.findById(id).get();
    }
}
