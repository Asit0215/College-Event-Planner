package com.example1.project1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FeedbackLogger {

    private static final Logger logger = LoggerFactory.getLogger(FeedbackLogger.class);

    public static void main(String[] args) {
        submitFeedback("Athithya", "Tech Fest 2025", "Great event! Loved the workshops.");
        submitFeedback("Anonymous", "Cultural Fest 2025", "The music night was amazing!");
        submitFeedback(null, "AI Workshop", "Could improve the session pace.");
    }

    public static void submitFeedback(String participantName, String eventName, String feedback) {
        if (participantName == null || participantName.trim().isEmpty() || participantName.equalsIgnoreCase("Anonymous")) {
            logger.info("Anonymous feedback for {}: {}", eventName, feedback);
        } else {
            logger.info("Feedback from {} for {}: {}", participantName, eventName, feedback);
        }
    }
}