import java.util.*;

public class EventManager {
    
    private Map<String, List<EventListener>> listeners = new HashMap<>();

    public EventManager(String... eventTypes) {
        for (String eventType : eventTypes) {
            listeners.put(eventType, new ArrayList<>());
        }
    }

    public void subscribe(String eventType, EventListener listener) {
        listeners.get(eventType).add(listener);
    }

    public void unsubscribe(String eventType, EventListener listener) {
        listeners.get(eventType).remove(listener);
    }

    public void notify(String eventType) {
        List<EventListener> eventTypeListeners = listeners.get(eventType);
        for (EventListener listener : eventTypeListeners) {
            listener.update(eventType);
        }
    }

}
