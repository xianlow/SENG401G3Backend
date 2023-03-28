package com.rhapsody.command.events;

import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
public class CreatePostEvent {
    @TargetAggregateIdentifier
    private final String id;
    private final String title;
    private final String content;

    private final String department;

}
