
package com.rhapsody.projection;


import com.rhapsody.command.events.CreatePostEvent;
import com.rhapsody.query.entity.RhapsodyModel;
import com.rhapsody.query.queries.ListAllPostsQuery;
import com.rhapsody.query.repository.PostsRepository;
import lombok.RequiredArgsConstructor;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class PostsRepositoryProjector {

    private final PostsRepository postsRepository;

    @EventHandler
    public void on(CreatePostEvent event) {
        RhapsodyModel rhapsodyModel = new RhapsodyModel(event.getId(), event.getTitle(), event.getContent(), event.getDepartment());
        this.postsRepository.save(rhapsodyModel);
    }

    @QueryHandler
    public List<RhapsodyModel> handle(ListAllPostsQuery query) {
        return this.postsRepository.findAll();
    }
}
