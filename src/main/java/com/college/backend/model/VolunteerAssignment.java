package com.college.backend.model;

public record VolunteerAssignment (
        int asgid,
        int userid,
        int eventid,
        String task
){}
