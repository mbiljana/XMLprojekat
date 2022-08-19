package com.example.Agent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class AgentApplication {

    private final InitialData initialData;

    @Autowired
    public AgentApplication(InitialData initialData){
        this.initialData = initialData;
    }
	public static void main(String[] args) {
		SpringApplication.run(AgentApplication.class, args);
	}

}
