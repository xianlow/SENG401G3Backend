package com.rhapsody.query.controller;

import com.rhapsody.query.entity.RhapsodyModel;
import com.rhapsody.query.queries.FindAllPostsQuery;
import com.rhapsody.query.service.PostsQueryService;
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
public class PostsQueryController {

    private final PostsQueryService postsQueryService;
    public PostsQueryController(PostsQueryService postsQueryService) {
        this.postsQueryService = postsQueryService;
    }

    @GetMapping("/")
    public List<RhapsodyModel> getAllPosts() throws Exception {

        return postsQueryService.findAllPosts();
    }

}
