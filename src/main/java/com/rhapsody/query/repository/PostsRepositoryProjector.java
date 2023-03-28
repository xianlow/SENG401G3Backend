
package com.rhapsody.query.repository;


import com.rhapsody.command.events.CreatePostEvent;
import com.rhapsody.query.entity.RhapsodyModel;
import com.rhapsody.query.queries.FindAllPostsQuery;
import com.rhapsody.query.repository.PostsRepository;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostsRepositoryProjector {

    private final PostsRepository postsRepository;
    public PostsRepositoryProjector(PostsRepository postsRepository) {
        this.postsRepository = postsRepository;
    }

    @EventHandler
    public void createPost(CreatePostEvent event) {
        RhapsodyModel rhapsodyModel = new RhapsodyModel();
        rhapsodyModel.setId(event.getId());
        rhapsodyModel.setTitle(event.getTitle());
        rhapsodyModel.setContent(event.getContent());
        postsRepository.save(rhapsodyModel);
    }
    @QueryHandler
    public List<RhapsodyModel> getAllPosts(FindAllPostsQuery query) {
        return postsRepository.findAll();
    }
}
