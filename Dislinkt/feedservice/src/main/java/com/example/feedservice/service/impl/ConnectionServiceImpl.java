package com.example.feedservice.service.impl;

import com.example.feedservice.model.Connection;
import com.example.feedservice.repository.ConnectionRepository;
import com.example.feedservice.service.ConnectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConnectionServiceImpl implements ConnectionService {

    private final ConnectionRepository connectionRepository;

    @Autowired
    public ConnectionServiceImpl(ConnectionRepository connectionRepository){
        this.connectionRepository = connectionRepository;
    }

    @Override
    public Connection findOne(Long id) {
        Connection connection = this.connectionRepository.findById(id).get();
        return connection;
    }
}
