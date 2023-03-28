package com.rhapsody.query.controller;

import com.rhapsody.query.entity.RhapsodyModel;
import com.rhapsody.query.queries.ListPostsDepartmentQuery;
import com.rhapsody.query.service.PostsQueryService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;


@RestController
@RequestMapping("/posts")
@Api(value = "Posts Query", description = "Posts Query API")
@AllArgsConstructor
public class PostsQueryController {

    private final PostsQueryService postsQueryService;


    @GetMapping("/department/{department}")
    public CompletableFuture<List<RhapsodyModel>> listByDepartment(@PathVariable(value = "department") String department) {

        return postsQueryService.listByDepartment(department);
    }

}
