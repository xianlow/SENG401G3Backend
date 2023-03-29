package com.rhapsody.command.commands;


import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;
@Data
public class CreatePostCommand {
    @TargetAggregateIdentifier
    private final String id;
    private final String title;
    private final String content;
    private final String department;

}
