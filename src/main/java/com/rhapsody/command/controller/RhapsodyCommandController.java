package com.rhapsody.command.controller;

import com.rhapsody.command.dto.PostsDTO;
import com.rhapsody.command.service.PostsCommandService;
import com.rhapsody.query.entity.RhapsodyModel;
import com.rhapsody.query.repository.PostsRepository;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping(value = "/home")
@Api(value = "Administration commands", description = "Administration commands API")
@AllArgsConstructor
public class RhapsodyCommandController {

    private final PostsCommandService postsCommandService;

    @PostMapping(value = "/adminpage")
    public CompletableFuture<RhapsodyModel> createPost(@RequestBody PostsDTO postsDTO) {
        return this.postsCommandService.createPost(postsDTO);
    }


}
