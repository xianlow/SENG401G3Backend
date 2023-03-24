package com.rhapsody.model;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

public class StringAggregate {
    private final String id;
    private String value;

    public StringAggregate(String id) {
        this.id = id;
        this.value = "";
    }

    public void apply(StringChangedEvent event) {
        if (!event.getId().equals(id)) {
            throw new IllegalArgumentException("Event with incorrect ID passed to StringAggregate");
        }
        this.value = event.getNewValue();
    }

    public List<StringChangedEvent> changeString(String newValue, LocalDateTime timestamp) {
        StringChangedEvent event = new StringChangedEvent(id, this.value, newValue, timestamp);
        apply(event);
        return Collections.singletonList(event);
    }

    public String getValue() {
        return value;
    }

    public List<StringChangedEvent> handle(ChangeStringCommand command, LocalDateTime timestamp) {
        List<StringChangedEvent> events = changeString(command.getNewValue(), timestamp);
        return events;
    }
}
