package com.example.feedservice.service;

import com.example.feedservice.model.Post;

import java.util.List;

public interface PostService {
    Post findOne(Long id);
    List<Post> findAll();
    Post create(Post post) throws Exception;
    void delete(Long id);
}
