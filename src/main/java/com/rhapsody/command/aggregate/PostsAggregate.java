package com.rhapsody.command.aggregate;
import com.rhapsody.command.commands.CreatePostCommand;
import com.rhapsody.command.events.*;
import com.rhapsody.query.queries.ListPostsDepartmentQuery;



import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.util.Assert;


import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Aggregate
public class PostsAggregate {
    @AggregateIdentifier
    private String id;
    private String title;
    private String content;
    private final Map<String, String> POSTS = new HashMap<>();
    protected PostsAggregate() {}
    @CommandHandler
    public PostsAggregate(CreatePostCommand command){
        apply(new CreatePostEvent(command.getId(), command.getTitle(), command.getContent(), command.getDepartment()));
    }
    @EventSourcingHandler
    public void on(CreatePostEvent event) {
        this.id = event.getId();
        this.title = event.getTitle();
        this.content = event.getContent();
        POSTS.put(title, content);

    }

    @QueryHandler
    public Map<String, String> handle(ListPostsDepartmentQuery query) {
        return this.POSTS;
    }

    public String getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getContent() {
        return content;
    }



}
