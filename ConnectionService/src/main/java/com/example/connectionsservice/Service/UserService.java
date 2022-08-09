package com.example.connectionsservice.Service;

import com.example.connectionsservice.Model.User;
import com.example.connectionsservice.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public User save(User user) {
        return this.userRepository.save(user);
    }
    public List<User> findByFirstNameAndLastName(User user) {
        return this.userRepository.findByFirstNameAndLastName(user.getFirstName(),user.getLastName());
    }


    public User follow(String followerUsername, String toFollowUsername) {
        //the user that sent the request
        User followerUser = userRepository.findByUsername(followerUsername);
        //user who got the request from another user
        User toFollowUser = userRepository.findByUsername(toFollowUsername);

        if(followerUser == null){
            throw new IllegalStateException("followerUser does not exist!");
        }
        if(toFollowUser == null){
            throw new IllegalStateException("toFollowUser does not exist!");
        }
        if(followerUser.getFollowing().contains(toFollowUsername)){
            throw new IllegalStateException("You already follow this user!");
        }

        if(toFollowUser.isPrivate()){
            toFollowUser.getFollowRequests().add(followerUsername);
            return userRepository.save(toFollowUser);
        }else{
            followerUser.getFollowing().add(toFollowUsername);
            return userRepository.save(followerUser);
        }
    }

    public List<User> getAll(){
        List<User> allUsers = userRepository.findAll();
        return allUsers;
    }
}
