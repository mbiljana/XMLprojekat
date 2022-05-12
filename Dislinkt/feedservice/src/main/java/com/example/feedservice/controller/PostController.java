package com.example.feedservice.controller;

import com.example.feedservice.model.Connection;
import com.example.feedservice.model.DTO.PostsDTO;
import com.example.feedservice.model.Post;
import com.example.feedservice.model.Profile;
import com.example.feedservice.service.ConnectionService;
import com.example.feedservice.service.PostService;
import com.example.feedservice.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "api/posts")
public class PostController {


    private final PostService postService;
    private final ProfileService profileService;
    private final ConnectionService connectionService;

    @Autowired
    public PostController(PostService postService, ProfileService profileService,ConnectionService connectionService ){
        this.postService = postService;
        this.connectionService = connectionService;
        this.profileService = profileService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PostsDTO>> getPosts(){
        List<Post>posts = this.postService.findAll();
        List<PostsDTO> postsDTOS = new ArrayList<>();
        for(Post p : posts){
            PostsDTO pDTO = new PostsDTO(p.getId(),p.getCreated(),p.getPost());
            postsDTOS.add(pDTO);
        }
        return new ResponseEntity<>(postsDTOS, HttpStatus.FOUND);
    }

    //metoda koja dobavlja sve konekcije za dati profil
    //te konekcije ce se prikazivati na pocetnoj stranici -- feed
    @GetMapping(value = "/feed",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PostsDTO>> getFeed(@RequestBody ActiveProfileDTO activeProfile){
        List<Post> posts = this.postService.findAll();
        Profile profile = this.profileService.findByUsername(activeProfile.getUsername());
        List<PostsDTO> postsDTOS = new ArrayList<>();
        List<Connection> connections = profile.getConnections();
        for(Post p : posts){
            for(Connection c : connections){
                if (p.getConnection().getId() == c.getId()){
                    PostsDTO pDTO = new PostsDTO(p.getId(),p.getCreated(),p.getPost());
                    postsDTOS.add(pDTO);
                }
            }
        }
        return new ResponseEntity<>(postsDTOS, HttpStatus.FOUND);
    }



}
