package com.example.followservice.model.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateProfileDTO {
    public Long id;
    public String username;
    public boolean isBlocked;
    public boolean isPublic;
}
