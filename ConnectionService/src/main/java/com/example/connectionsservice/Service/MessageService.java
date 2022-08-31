package com.example.connectionsservice.Service;

import com.example.connectionsservice.Dto.MessageDTO;
import com.example.connectionsservice.Model.Message;
import com.example.connectionsservice.Model.Notification;
import com.example.connectionsservice.Model.User;
import com.example.connectionsservice.Repository.MessageRepository;
import com.example.connectionsservice.Repository.NotificationRepository;
import com.example.connectionsservice.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private UserRepository userRepository;

   // @Autowired
   // private NotificationRepository notificationRepository;
    @Autowired
    private NotificationService notificationService;

    public Message save(Message message){
        return this.messageRepository.save(message);
    }

    //chat with one person
    public List<Message> findRecievedMessages(String username, String sender){
        List<Message> messages1 = new ArrayList<>();
        List<Message> messages2 = new ArrayList<>();
        messages1 = messageRepository.findMessageByRecieverUsernameAndSenderUsernameOrderBySentDateAsc(username,sender);
        messages2 = this.messageRepository.findMessageByRecieverUsernameAndSenderUsernameOrderBySentDateAsc(sender,username);
        messages1.addAll(messages2);
        Collections.sort(messages1, Comparator.comparing(Message::getSentDate));

        return messages1;
    }
    

    //chat "interface"
    public List<Message> getChatInterface(String username){
        User user = this.userRepository.findByUsername(username);
        List<Message> allUsersMsgs =  messageRepository.findMessageByRecieverUsername(user.getUsername());
        List<Message> interfaceMsgs = new ArrayList<>();
        List<Message> tmp = new ArrayList<>();
        Set<String> senderNames = new HashSet<>();
        Message mh = new Message("maja","lana99","bla");
        for (Message m: allUsersMsgs) {
            if(senderNames.isEmpty()){
                senderNames.add(m.getSenderUsername());
                tmp = this.messageRepository.findMessageByRecieverUsernameAndSenderUsernameOrderBySentDateAsc(user.getUsername(),m.getSenderUsername());
                interfaceMsgs.add(tmp.get(tmp.size()-1));
            }else if (!senderNames.contains(m.getSenderUsername())){
                senderNames.add(m.getSenderUsername());
                tmp = this.messageRepository.findMessageByRecieverUsernameAndSenderUsernameOrderBySentDateAsc(user.getUsername(),m.getSenderUsername());
                interfaceMsgs.add(tmp.get(tmp.size()-1));
            }else{
                tmp.clear();
            }
        }
        Collections.sort(interfaceMsgs, Comparator.comparing(Message::getSentDate));


        return interfaceMsgs;
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
        if(userSender.getSentMessages() == null){
            List<Message> sent = new ArrayList<>();
            userSender.setSentMessages(sent);
            userRepository.save(userSender);
        }else{
            userSender.getSentMessages().add(message);
            userRepository.save(userSender);
        }



        Notification notification = new Notification(message,date, userSender.getUsername());
        this.notificationService.saveNotif(notification);
        List<Notification> not = new ArrayList<>();
        not.add(notification);
        userReciever.getMessagesNotifications().add(notification);
        this.userRepository.save(userReciever);
        return  message;
    }

    public List<Message> getAll(){
        return this.messageRepository.findAll();
    }

    public Notification getNotif(Long id){
        return this.notificationService.findOne(id);
    }


}
