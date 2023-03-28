package com.rhapsody.command.controller;

import com.rhapsody.command.dto.PostsDTO;
import com.rhapsody.command.service.PostsCommandService;
import com.rhapsody.query.entity.RhapsodyModel;
import com.rhapsody.query.repository.PostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping
@ResponseBody
public class RhapsodyCommandController {

    private final PostsCommandService postsCommandService;
    @Autowired
    public RhapsodyCommandController(PostsCommandService postsCommandService) {
        this.postsCommandService = postsCommandService;
    }
    @PostMapping(value = "/adminpage")
    public String createPost(@RequestBody RhapsodyModel model) {
        String output = postsCommandService.createPost(model, UUID.randomUUID().toString());
        return output;
    }


}
