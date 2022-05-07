package com.example.feedservice.repository;

import com.example.feedservice.model.Connection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConnectionRepository extends JpaRepository<Connection,Long> {
}
