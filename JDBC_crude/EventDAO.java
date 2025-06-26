package JDBC_crude;

import java.util.List;

public interface EventDAO {
    void addEvent(Event event);
    Event getEventById(int id);
    List<Event> getAllEvents();
    List<Event> getEventsByUserId(int userId);
    void updateEvent(Event event);
    void deleteEvent(int id);

}
