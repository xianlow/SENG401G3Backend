package com.rhapsody.query.service;

import com.rhapsody.query.entity.RhapsodyModel;
import com.rhapsody.query.queries.ListPostsDepartmentQuery;
import lombok.AllArgsConstructor;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.stereotype.Service;
import org.axonframework.messaging.Message;
import org.axonframework.messaging.responsetypes.ResponseTypes;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PostsQueryService {

    private final QueryGateway queryGateway;
    private final EventStore eventStore;


    public CompletableFuture<List<RhapsodyModel>> listByDepartment(String department){
        System.out.println(department);
        return queryGateway.query(department, ResponseTypes.multipleInstancesOf(RhapsodyModel.class));
    }


}
