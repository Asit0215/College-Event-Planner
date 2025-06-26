package JDBC_crude;

import java.util.List;

public interface VolunteerAssignmentDAO {
    void addAssignment(VolunteerAssignment assignment);
    VolunteerAssignment getAssignmentById(int id);
    List<VolunteerAssignment> getAssignmentsByUserId(int userId);
    List<VolunteerAssignment> getAssignmentsByEventId(int eventId);
    void updateAssignment(VolunteerAssignment assignment);
    void deleteAssignment(int id);
}
