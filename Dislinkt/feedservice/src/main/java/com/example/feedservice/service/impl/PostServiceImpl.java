package com.example.feedservice.service.impl;

import com.example.feedservice.model.Post;
import com.example.feedservice.repository.PostRepository;
import com.example.feedservice.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository){
        this.postRepository = postRepository;
    }

    @Override
    public Post findOne(Long id) {
        Post post = this.postRepository.findById(id).get();
        return post;
    }

    @Override
    public List<Post> findAll() {
        List<Post> posts = this.postRepository.findAll();
        return posts;
    }

    @Override
    public Post create(Post post) throws Exception {
        if(post.getId() != null){
            throw new Exception("Post with given ID already exists.");
        }
        Post newC = this.postRepository.save(post);
        return  newC;
    }

    @Override
    public void delete(Long id) {
        this.postRepository.deleteById(id);
    }
}
