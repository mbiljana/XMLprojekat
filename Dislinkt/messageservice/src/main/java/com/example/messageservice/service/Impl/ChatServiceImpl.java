package com.example.messageservice.service.Impl;

import com.example.messageservice.model.Chat;
import com.example.messageservice.model.Profile;
import com.example.messageservice.repository.ChatRepository;
import com.example.messageservice.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatServiceImpl implements ChatService {
    private final ChatRepository chatRepository;

    @Autowired
    public ChatServiceImpl(ChatRepository chatRepository) {
        this.chatRepository = chatRepository;
    }

    @Override
    public Chat findOne(Long id) {
        Chat chat = this.chatRepository.findById(id).get();
        return chat;
    }

    @Override
    public List<Chat> findAll() {
        List<Chat> chats = this.chatRepository.findAll();
        return chats;
    }

    @Override
    public Chat create(Chat chat) throws Exception {
        if(chat.getId() != null) {
            throw new Exception("ID must be null");
        }
        Chat newChat = this.chatRepository.save(chat);
        return newChat;
    }

    @Override
    public Chat update(Chat chat) throws Exception {
        Chat updateChat = this.chatRepository.findById(chat.getId()).get();
        if (chat.getId() == null){
            throw new Exception("Chat doesn't exist");
        }

        updateChat.setProfilesInChat(chat.getProfilesInChat());
        updateChat.setAllMessages(chat.getAllMessages());
        Chat updated = this.chatRepository.save(updateChat);

        return updated;
    }

    @Override
    public void delete(Long id) {
        this.chatRepository.deleteById(id);
    }
}
