package com.college.backend.model;

public final class Volunteer extends User {
    private String taskAsg;
    public Volunteer(int userid, String name, String email, String phone, String taskAsg) {
        super(userid, name, email, "Volunteer", phone);
        this.taskAsg = taskAsg;
    }
    public String getTaskAsg() {
        return taskAsg;
    }
}
