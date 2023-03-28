
package com.rhapsody.projection;


import com.rhapsody.command.events.CreatePostEvent;
import com.rhapsody.query.entity.RhapsodyModel;
import com.rhapsody.query.queries.ListPostsDepartmentQuery;
import com.rhapsody.query.repository.PostsRepository;
import lombok.RequiredArgsConstructor;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class PostsRepositoryProjector {

    private final PostsRepository postsRepository;

    @EventHandler
    public void on(CreatePostEvent event) {
        RhapsodyModel rhapsodyModel = new RhapsodyModel(event.getId(), event.getDepartment(), event.getTitle(), event.getContent());
        this.postsRepository.save(rhapsodyModel);
    }
    @QueryHandler
    public Optional<RhapsodyModel> handle(ListPostsDepartmentQuery query) {
        return this.postsRepository.findById(query.getDepartment());
    }
}
