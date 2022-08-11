package com.example.connectionsservice.Service;

import com.example.connectionsservice.Model.User;
import com.example.connectionsservice.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public User findByUsername(String username) {
       return this.userRepository.findByUsername(username);
    }


    //follow a user
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

    //get all follow request for user
    public List<String> getFollowRequests(String username){
        List<String> followRequest = new ArrayList<>();
        User user = userRepository.findByUsername(username);
        followRequest = user.getFollowRequests();
        return  followRequest;
    }

    //confirm a request
    public List<String> confirmRequest(String username, String followerUsername){
        //user koji je primio zahtev
        User user = userRepository.findByUsername(username);
        //user koji je poslao zahtev
        User follower = userRepository.findByUsername(followerUsername);

        //lista ljudi koje prati user koji je zapratio
        List<String> userFollowing = follower.getFollowing();
        //zahtevi koje je primio user
        List<String> userRequests = user.getFollowRequests();
        for (String f: user.getFollowRequests()
             ) {
            if(f.equals(follower.getUsername())){
                userFollowing.add(user.getUsername());
                userRequests.remove(f);
                userRepository.save(user);
                userRepository.save(follower);
                break;
            }
        }
        return userRequests;
    }


}
