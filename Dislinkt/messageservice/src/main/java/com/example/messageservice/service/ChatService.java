package com.example.messageservice.service;

import com.example.messageservice.model.Chat;
import com.example.messageservice.model.Profile;

import java.util.List;

public interface ChatService {
    Chat findOne(Long id);
    List<Chat> findAll();
    Chat create(Chat chat) throws Exception;
    Chat update(Chat chat) throws Exception;
    void delete(Long id);

}
