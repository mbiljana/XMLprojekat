package com.example.securityservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class SecurityServiceApplication {


    private final InitialData initialData;

    @Autowired
    public SecurityServiceApplication(InitialData initialData){
        this.initialData = initialData;
    }


    public static void main(String[] args) {
        SpringApplication.run(SecurityServiceApplication.class, args);
    }

}
