package com.example.followservice.service;

import com.example.followservice.model.Connection;

import java.util.List;

public interface ConnectionService {
    Connection findOne(Long id);
    List<Connection> findAll();
    Connection create (Connection connection) throws Exception;
}
