package com.example1.project1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EventCancellationLogger {

    private static final Logger logger = LoggerFactory.getLogger(EventCancellationLogger.class);

    public static void main(String[] args) {
        cancelEvent("Tech Fest 2025", "Insufficient registrations");
        cancelEvent("AI Workshop", "Speaker unavailable");
        cancelEvent("Sports Day", "Weather conditions");
    }

    public static void cancelEvent(String eventName, String reason) {
        if (eventName == null || eventName.isEmpty()) {
            logger.error("Attempted to cancel an event with no name provided.");
            return;
        }

        logger.warn("Event cancelled: {} | Reason: {}", eventName, reason);
    }
}
