import java.util.ArrayList;
import java.util.List;

public class Example {
    public static void main(String[] args) {
        EventStore eventStore = new EventStore();
        StringCommandQuery commandHandler = new StringCommandQuery(eventStore);
        StringQueryHandler queryHandler = new StringQueryHandler(eventStore);

        String id = "123";
        commandHandler.handle(new ChangeStringCommand(id, "hello"));
        commandHandler.handle(new ChangeStringCommand(id, "hello world"));
        commandHandler.handle(new ChangeStringCommand(id, "please"));
        commandHandler.handle(new ChangeStringCommand(id, "keep"));
        commandHandler.handle(new ChangeStringCommand(id, "working"));
        commandHandler.handle(new ChangeStringCommand(id, "please"));
        commandHandler.handle(new ChangeStringCommand(id, "thank you"));
        commandHandler.handle(new ChangeStringCommand(id, "nice"));

        List<StringChangedEvent> eventsForID = new ArrayList<>();

        eventsForID = eventStore.getEventsForId(id);

        
        for(StringChangedEvent event : eventsForID){
            System.out.println(event.getNewValue());
        }

       System.out.println(queryHandler.getValue(id)); // prints "nice"
    }
}
