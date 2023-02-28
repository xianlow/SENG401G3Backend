import java.time.LocalDateTime;

public class StringChangedEvent {
    private final String id;
    private final String oldValue;
    private final String newValue;
    private final LocalDateTime timestamp;

    public StringChangedEvent(String id, String oldValue, String newValue, LocalDateTime timestamp) {
        this.id = id;
        this.oldValue = oldValue;
        this.newValue = newValue;
        this.timestamp = timestamp;
    }

    public String getId() {
        return id;
    }

    public String getOldValue() {
        return oldValue;
    }

    public String getNewValue() {
        return newValue;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
