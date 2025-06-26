package JDBC_crude;

public class VolunteerAssignment {
    private int assignmentId;
    private int userId;
    private int eventId;
    private String task;

    public VolunteerAssignment() {}

    public VolunteerAssignment(int assignmentId, int userId, int eventId, String task) {
        this.assignmentId = assignmentId;
        this.userId = userId;
        this.eventId = eventId;
        this.task = task;
    }

    // Getters and Setters
    public int getAssignmentId() { return assignmentId; }
    public void setAssignmentId(int assignmentId) { this.assignmentId = assignmentId; }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public int getEventId() { return eventId; }
    public void setEventId(int eventId) { this.eventId = eventId; }

    public String getTask() { return task; }
    public void setTask(String task) { this.task = task; }
}
