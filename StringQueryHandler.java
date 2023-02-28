public class StringQueryHandler {
    private final EventStore eventStore;

    public StringQueryHandler(EventStore eventStore) {
        this.eventStore = eventStore;
    }

    public String getValue(String id) {
        StringChangedEvent latestEvent = eventStore.getLatestEvent(id);
        if (latestEvent == null) {
            return null;
        }
        return latestEvent.getNewValue();
    }
}
