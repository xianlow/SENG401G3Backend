import java.time.LocalDateTime;
import java.util.UUID;

public abstract class Event {
    private final String eventId;
    private final LocalDateTime timestamp;
    private final String aggregateId;

    public Event(String aggregateId) {
        this.eventId = UUID.randomUUID().toString();
        this.timestamp = LocalDateTime.now();
        this.aggregateId = aggregateId;
    }

    public String getEventId() {
        return eventId;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getAggregateId() {
        return aggregateId;
    }
}
