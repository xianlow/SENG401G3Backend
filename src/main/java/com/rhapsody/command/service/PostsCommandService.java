package com.rhapsody.command.service;

import com.fasterxml.jackson.databind.deser.std.UUIDDeserializer;
import com.rhapsody.command.dto.PostsDTO;
import com.rhapsody.command.commands.CreatePostCommand;
import com.rhapsody.query.entity.RhapsodyModel;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
public class PostsCommandService {

    private final CommandGateway commandGateway;
    @Autowired
    public PostsCommandService(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    public String createPost(RhapsodyModel model, String uid){


        commandGateway.send(new CreatePostCommand(uid, model.getTitle(), model.getContent()));
        return "Created";
    }
}
