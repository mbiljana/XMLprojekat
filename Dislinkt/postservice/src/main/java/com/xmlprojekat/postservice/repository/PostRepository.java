package com.xmlprojekat.postservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xmlprojekat.postservice.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>{

}
