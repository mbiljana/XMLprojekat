package com.example.connectionsservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class ConnectionsServiceApplication {


    @Autowired
    InitialData initialData;

    public static void main(String[] args) {
        SpringApplication.run(ConnectionsServiceApplication.class, args);
    }

}
