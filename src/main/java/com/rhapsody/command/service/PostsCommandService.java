package com.rhapsody.command.service;

import com.fasterxml.jackson.databind.deser.std.UUIDDeserializer;
import com.rhapsody.command.dto.PostsDTO;
import com.rhapsody.command.commands.CreatePostCommand;
import com.rhapsody.query.entity.RhapsodyModel;
import lombok.AllArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
@AllArgsConstructor
public class PostsCommandService {

    private final CommandGateway commandGateway;


    public CompletableFuture<RhapsodyModel> createPost(PostsDTO postsDTO) {


        return this.commandGateway.send(new CreatePostCommand(UUID.randomUUID().toString(), postsDTO.getTitle(), postsDTO.getContent(), postsDTO.getDepartment()));


    }

    
}
