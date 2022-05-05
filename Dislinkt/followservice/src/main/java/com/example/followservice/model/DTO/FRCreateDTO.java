package com.example.followservice.model.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FRCreateDTO {

    public Long id;
    public Long followingID;
    public Long requestingID;
    public Date reqDate;
}
