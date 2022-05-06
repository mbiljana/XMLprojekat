package com.example.messageservice.service;

import com.example.messageservice.model.Chat;
import com.example.messageservice.model.Message;
import com.example.messageservice.model.Profile;

import java.util.List;

public interface MessageService {
    Message findOne(Long id);
    List<Message> findAll();
    Message create(Message message) throws Exception;
    Message update(Message message) throws Exception;
    void delete(Long id);
}
