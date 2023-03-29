package com.rhapsody.command.controller;

import com.rhapsody.command.dto.PostsDTO;
import com.rhapsody.command.service.PostsCommandService;
import com.rhapsody.projection.PostsRepositoryProjector;
import com.rhapsody.query.entity.RhapsodyModel;
import com.rhapsody.query.repository.PostsRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping
@AllArgsConstructor
public class RhapsodyCommandController {

    private final PostsCommandService postsCommandService;
    @PostMapping(value = "/adminpage")
    public CompletableFuture<RhapsodyModel> createPost(@RequestBody PostsDTO postsDTO) {
        return this.postsCommandService.createPost(postsDTO);
    }


}
