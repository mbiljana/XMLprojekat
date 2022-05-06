package com.example.messageservice.service.Impl;

import com.example.messageservice.model.Message;
import com.example.messageservice.model.Profile;
import com.example.messageservice.repository.MessageRepository;
import com.example.messageservice.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.invoke.WrongMethodTypeException;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
    private final MessageRepository messageRepository;

    @Autowired
    public MessageServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public Message findOne(Long id) {
        Message message = this.messageRepository.findById(id).get();
        return message;
    }

    @Override
    public List<Message> findAll() {
        List<Message> messages = this.messageRepository.findAll();
        return messages;
    }

    @Override
    public Message create(Message message) throws Exception {
        if(message.getId() != null) {
            throw new Exception("ID must be null");
        }
        Message newMessage = this.messageRepository.save(message);
        return newMessage;
    }

    @Override
    public Message update(Message message) throws Exception {
        Message updateMessage = this.messageRepository.findById(message.getId()).get();
        if(message.getId() == null) {
            throw new Exception("Message doesn't exist");
        }
        updateMessage.setSeen(message.isSeen());
        updateMessage.setText(message.getText());
        updateMessage.setTime(message.getTime());
        updateMessage.setMessages(message.getMessages());

        Message updated = this.messageRepository.save(updateMessage);
        return updated;
    }

    @Override
    public void delete(Long id) {
        this.messageRepository.deleteById(id);
    }
}
