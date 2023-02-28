import java.time.LocalDateTime;
import java.util.List;

public class StringCommandQuery {
    private final EventStore eventStore;

    public StringCommandQuery(EventStore eventStore) {
        this.eventStore = eventStore;
    }

    public String getValue(String id) {
        List<StringChangedEvent> events = eventStore.getEventsForAggregate(id);
        StringAggregate aggregate = new StringAggregate(id);
        for (StringChangedEvent event : events) {
            aggregate.apply(event);
        }
        return aggregate.getValue();
    }

    public List<StringChangedEvent> handle(ChangeStringCommand command) {
        StringAggregate aggregate = new StringAggregate(command.getId());
        List<StringChangedEvent> events = eventStore.getEventsForAggregate(command.getId());
        for (StringChangedEvent event : events) {
            aggregate.apply(event);
        }
        LocalDateTime timestamp = LocalDateTime.now();
        events = aggregate.handle(command, timestamp);
        eventStore.saveEvents(events);
        return events;
    }
}
