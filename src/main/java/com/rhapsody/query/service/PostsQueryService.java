package com.rhapsody.query.service;

import com.rhapsody.query.entity.RhapsodyModel;
import com.rhapsody.query.queries.FindAllPostsQuery;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.axonframework.messaging.responsetypes.ResponseTypes;

import java.util.List;

@Service
public class PostsQueryService {

    private final QueryGateway queryGateway;
    @Autowired
    public PostsQueryService(QueryGateway queryGateway) {
        this.queryGateway = queryGateway;
    }

    public List<RhapsodyModel> findAllPosts()throws Exception{

        return queryGateway.query(new FindAllPostsQuery(), ResponseTypes.multipleInstancesOf(RhapsodyModel.class)).get();
    }


}
