package com.example.Profile.dto;

public class SearchJobDTO {
    //job title
    private String title;

    public SearchJobDTO(String title) {
        this.title = title;
    }

    public SearchJobDTO() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
