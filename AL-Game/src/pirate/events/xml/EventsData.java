package pirate.events.xml;

import java.util.Collection;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import org.slf4j.LoggerFactory;
import pirate.events.enums.EventType;

/**
 *
 * @author flashman
 */
@XmlRootElement(name = "events")
@XmlAccessorType(XmlAccessType.FIELD)
public class EventsData {

    @XmlElement(name = "event")
    private List<EventTemplate> events;
    private Map<EventType, EventTemplate> eventsByType;

    void afterUnmarshal(Unmarshaller u, Object parent) {
        eventsByType = new EnumMap<EventType, EventTemplate>(EventType.class);
        for (EventTemplate et : events) {
            if (this.eventsByType.containsKey(et.getEventType())) {
                LoggerFactory.getLogger(EventsData.class).info("[afterUnmarshal] Events map contains type: {}", et.getEventType().name());
                continue;
            }
            this.eventsByType.put(et.getEventType(), et);
        }
    }

    public int size() {
        return this.eventsByType.size();
    }

    public EventTemplate getEventTemplate(EventType type) {
        return this.eventsByType.get(type);
    }

    /**
     * List Eventov after marshaling.
     *
     * @return
     */
    public Collection<EventTemplate> getMappedEvents() {
        return this.eventsByType.values();
    }

    /**
     * List with opening event to be marshaled.
     *
     * @return
     */
    public List<EventTemplate> getNotMappedEvents() {
        return events;
    }

    public void setEvents(List<EventTemplate> events) {
        this.events = events;
        this.afterUnmarshal(null, null);
    }
}
