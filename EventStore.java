import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventStore {

    private final Map<String, List<StringChangedEvent>> eventsByAggregateId;

    public EventStore() {
        eventsByAggregateId = new HashMap<>();
    }


    public List<StringChangedEvent> getEventsForId(String id) {
        List<StringChangedEvent> eventsForId = new ArrayList<>();
        for (List<StringChangedEvent> events : eventsByAggregateId.values()) {
            for (StringChangedEvent event : events) {
                if (event.getId().equals(id)) {
                    eventsForId.add(event);
                }
            }
        }
        return eventsForId;
    }

    public StringChangedEvent getLatestEvent(String id) {
        List<StringChangedEvent> eventsForId = getEventsForId(id);
        if (eventsForId.isEmpty()) {
            return null;
        }
        return eventsForId.get(eventsForId.size() - 1);
    }
    public void saveEvents(List<StringChangedEvent> events) {
        for (StringChangedEvent event : events) {
            List<StringChangedEvent> eventsForAggregate = eventsByAggregateId.computeIfAbsent(event.getId(), k -> new ArrayList<>());
            eventsForAggregate.add(event);
        }
    }

    public List<StringChangedEvent> getEventsForAggregate(String aggregateId) {
        return eventsByAggregateId.getOrDefault(aggregateId, new ArrayList<>());
    }

    
}
