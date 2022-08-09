package com.example.connectionsservice.Model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document("posts")
public class Post {
    @Id
    private Long id;
}
