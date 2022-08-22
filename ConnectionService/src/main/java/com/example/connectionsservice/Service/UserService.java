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

    public User findOne(Long id) {
        return this.userRepository.findById(id).get();
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
            toFollowUser.getFollowing().add(followerUsername);
            userRepository.save(toFollowUser);
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

    public List<String> getFollowRequestsId(Long id){
        List<String> followRequest = new ArrayList<>();
        User user = userRepository.findById(id).get();
        followRequest = user.getFollowRequests();
        return  followRequest;
    }

    //get all users connections
    public List<String> getUsersConnections(String username){
        List<String> following = new ArrayList<>();
        User user = userRepository.findByUsername(username);
        following = user.getFollowing();
        return  following;
    }

    //get all users connections by id
    public List<String> getUsersConnectionsId(Long id){
        List<String> following = new ArrayList<>();
        User user = userRepository.findById(id).get();
        following = user.getFollowing();
        return  following;
    }



    //confirm a request
    public String confirmRequest(String username, String followerUsername){
        //user koji je primio zahtev
        User user = userRepository.findByUsername(username);
        //user koji je poslao zahtev
        User follower = userRepository.findByUsername(followerUsername);

        //lista ljudi koje prati user koji je zapratio
        List<String> userFollowing = follower.getFollowing();
        List<String> otherSideFollow = user.getFollowing();
        //zahtevi koje je primio user
        List<String> userRequests = user.getFollowRequests();
        for (String f: user.getFollowRequests()
             ) {
            if(f.equals(follower.getUsername())){
                userFollowing.add(user.getUsername());
                otherSideFollow.add(follower.getUsername());
                userRequests.remove(f);
                userRepository.save(user);
                userRepository.save(follower);
                break;
            }
        }
        String flw = follower.getUsername();
        return flw;
    }

    public boolean isUserFollowing(Long idUser, Long idFollower){
        User u1 = this.userRepository.findById(idUser).get();
        User u2 = this.userRepository.findById(idFollower).get();
        boolean ret = false;
        for (String s: u1.getFollowing()) {
            if(s.equals(u2.getUsername())){
                ret = true;
            }else{
                ret = false;
            }
        }
        return ret;
    }


}
