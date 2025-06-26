package com.college.backend.model;

public record Feedback (
        int feedbackid,
        int userid,
        int eventid,
        int rating,
        String comments
){}