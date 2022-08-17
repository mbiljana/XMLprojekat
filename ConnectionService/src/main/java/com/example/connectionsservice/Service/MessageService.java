package com.example.connectionsservice.Service;

import com.example.connectionsservice.Dto.MessageDTO;
import com.example.connectionsservice.Model.Message;
import com.example.connectionsservice.Model.User;
import com.example.connectionsservice.Repository.MessageRepository;
import com.example.connectionsservice.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private UserRepository userRepository;

    public Message save(Message message){
        return this.messageRepository.save(message);
    }

    public List<Message> findRecievedMessages(String username, String sender){
        return messageRepository.findMessageByRecieverUsernameAndSenderUsername(username,sender);
    }

    public List<Message> findSentMessages(String username){
        return messageRepository.findMessageBySenderUsername(username);
    }

    public Message sendMessage(String sender, String reciever, String mess){
        User userSender = this.userRepository.findByUsername(sender);
        User userReciever = this.userRepository.findByUsername(reciever);
        String mes = mess;
        Date date = new Date();
        MessageDTO messageDTO = new MessageDTO(userSender.getUsername(),userReciever.getUsername(),mes);
        Message message = new Message();
        message.setRecieverUsername(messageDTO.getRecieverUsername());
        message.setSenderUsername(messageDTO.getSenderUsername());
        message.setMessage(messageDTO.getMessage());
        message.setSentDate(date);
        this.messageRepository.save(message);
        userReciever.getRecievedMessages().add(message);
        userRepository.save(userReciever);
        userSender.getSentMessages().add(message);
        userRepository.save(userSender);
        return  message;
    }

    public List<Message> getAll(){
        return this.messageRepository.findAll();
    }


}
