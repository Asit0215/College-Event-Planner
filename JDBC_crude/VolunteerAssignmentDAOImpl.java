package JDBC_crude;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VolunteerAssignmentDAOImpl implements VolunteerAssignmentDAO {

    private Connection conn;

    public VolunteerAssignmentDAOImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void addAssignment(VolunteerAssignment assignment) {
        String sql = "INSERT INTO volunteer_assignments (user_id, event_id, task) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, assignment.getUserId());
            stmt.setInt(2, assignment.getEventId());
            stmt.setString(3, assignment.getTask());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public VolunteerAssignment getAssignmentById(int id) {
        String sql = "SELECT * FROM volunteer_assignments WHERE assignment_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return extractAssignment(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<VolunteerAssignment> getAssignmentsByUserId(int userId) {
        List<VolunteerAssignment> list = new ArrayList<>();
        String sql = "SELECT * FROM volunteer_assignments WHERE user_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                list.add(extractAssignment(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<VolunteerAssignment> getAssignmentsByEventId(int eventId) {
        List<VolunteerAssignment> list = new ArrayList<>();
        String sql = "SELECT * FROM volunteer_assignments WHERE event_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, eventId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                list.add(extractAssignment(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void updateAssignment(VolunteerAssignment assignment) {
        String sql = "UPDATE volunteer_assignments SET user_id = ?, event_id = ?, task = ? WHERE assignment_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, assignment.getUserId());
            stmt.setInt(2, assignment.getEventId());
            stmt.setString(3, assignment.getTask());
            stmt.setInt(4, assignment.getAssignmentId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteAssignment(int id) {
        String sql = "DELETE FROM volunteer_assignments WHERE assignment_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private VolunteerAssignment extractAssignment(ResultSet rs) throws SQLException {
        return new VolunteerAssignment(
                rs.getInt("assignment_id"),
                rs.getInt("user_id"),
                rs.getInt("event_id"),
                rs.getString("task")
        );
    }
}
