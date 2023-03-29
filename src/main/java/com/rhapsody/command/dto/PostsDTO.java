package com.rhapsody.command.dto;


import lombok.Value;

@Value
public class PostsDTO {

    private final String id;
    private final String content;
    private final String title;
    private final String department;

}
