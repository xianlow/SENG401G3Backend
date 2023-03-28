package com.rhapsody.command.dto;

import lombok.Data;

@Data
public class PostsDTO {

    private int id;
    private String content;
    private String title;
    public int getId() {
        return id;
    }
    public String getContent() {
        return content;
    }
    public String getTitle() {
        return title;
    }
}
