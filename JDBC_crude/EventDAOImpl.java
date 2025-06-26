package JDBC_crude;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class EventDAOImpl implements EventDAO {
    private Connection conn;
    public EventDAOImpl(Connection conn) {
        this.conn = conn;
    }
    public void addEvent(Event event) {
        String sql = "INSERT INTO events (event_name, description, event_date, location, created_by) VALUES (?,?,?,?,?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, event.getEventName());
            stmt.setString(2, event.getDescription());
            stmt.setDate(3, event.getEventDate());
            stmt.setString(4, event.getLocation());
            stmt.setInt(5, event.getCreatedBy());
            stmt.executeUpdate();
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
    }
    public Event getEventById(int id) {
        String sql = "SELECT * FROM events WHERE event_id = ?";
        try(PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1,id);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()) {
                return extractEvent(rs);
            }

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<Event> getAllEvents() {
        List<Event> events = new ArrayList<>();
        String sql = "SELECT * FROM events";
        try (Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){
            while(rs.next()) {
                events.add(extractEvent(rs));
            }
        }
        catch (SQLException e) {

        }
        return events;
    }
    public List<Event> getEventsByUserId(int userId) {
        List<Event> events = new ArrayList<>();
        String sql = "SELECT * FROM events WHERE created_by = ?";
        try(PreparedStatement stmt =conn.prepareStatement(sql)){
            stmt.setInt(1,userId);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                events.add(extractEvent(rs));
            }
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        return events;
    }
    public void updateEvent(Event event) {
        String sql = "UPDATE events SET event_name=?, description=?, event_date=?, location=? WHERE event_id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, event.getEventName());
            stmt.setString(2, event.getDescription());
            stmt.setDate(3, event.getEventDate());
            stmt.setString(4, event.getLocation());
            stmt.setInt(5, event.getCreatedBy());
            stmt.setInt(5, event.getEventId());
            stmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void deleteEvent(int id) {
        String sql = "DELETE FROM events WHERE event_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private Event extractEvent(ResultSet rs) throws SQLException {
        return new Event(
                rs.getInt("event_id"),
                rs.getString("event_name"),
                rs.getString("description"),
                rs.getDate("event_date"),
                rs.getString("location"),
                rs.getInt("created_by")
        );
    }
}
