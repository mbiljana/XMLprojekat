package com.example.followservice.service.impl;

import com.example.followservice.model.Connection;
import com.example.followservice.repository.ConnectionRepository;
import com.example.followservice.service.ConnectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<Connection> findAll() {
        List<Connection> connections = this.connectionRepository.findAll();
        return connections;
    }

    @Override
    public Connection create(Connection connection) throws Exception {
        if(connection.getId() != null){
            throw new Exception("ID must be null!");
        }
        Connection newC = this.connectionRepository.save(connection);
        return newC;
    }
}
