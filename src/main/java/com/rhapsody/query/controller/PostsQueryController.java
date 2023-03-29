package com.rhapsody.query.controller;

import com.rhapsody.query.entity.RhapsodyModel;
import com.rhapsody.query.service.PostsQueryService;
import lombok.AllArgsConstructor;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping
@AllArgsConstructor
public class PostsQueryController {

    private final PostsQueryService postsQueryService;


    @GetMapping("/")
    public CompletableFuture<List<RhapsodyModel>> findAllPosts() {

        return postsQueryService.findAllPosts();
    }

}
