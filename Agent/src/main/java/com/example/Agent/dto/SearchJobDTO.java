package com.example.Agent.dto;

public class SearchJobDTO {
    //job position
    private String position;

    public SearchJobDTO(String position) {
        this.position = position;
    }

    public SearchJobDTO() {
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
