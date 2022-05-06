package com.example.messageservice.repository;

import com.example.messageservice.model.Chat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRepository extends JpaRepository<Chat, Long> {
}
