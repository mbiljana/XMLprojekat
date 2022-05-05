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
public class FollowRequestDTO {
    public Long id;
    public Long profileId;
    public Date reqDate;
}
