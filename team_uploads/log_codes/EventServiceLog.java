package com.example1.project1;

import org.apache.logging.log4j.LogManager;

//import org.apache.logging.log4j.Logger;
//import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class EventServiceLog {

//    private static final Logger logger = LogManager.getLogger(EventServiceLog.class);
//
//    public static void main(String[] args) {
//        createEvent("Tech Fest 2025");
//        cancelEvent("Workshop on AI");
//        submitFeedback("Tech Fest 2025", "Amazing event!");
//    }
//
//    public static void createEvent(String eventName) {
//        logger.info("Event created: {}", eventName);
//    }
//
//    public static void cancelEvent(String eventName) {
//        logger.info("Event cancelled: {}", eventName);
//    }
//
//    public static void submitFeedback(String eventName, String feedback) {
//        logger.info("Feedback submitted for {}: {}", eventName, feedback);
//    }
	
	
	private static final Logger logger = LoggerFactory.getLogger(EventServiceLog.class);

    public static void main(String[] args) {
        logger.info("EventLogger started...");
        createEvent("Tech Fest");
        cancelEvent("Cultural Night");
        submitFeedback("Tech Fest", "Awesome event!");
    }

    public static void createEvent(String eventName) {
        logger.info("Event created: {}", eventName);
    }

    public static void cancelEvent(String eventName) {
        logger.info("Event cancelled: {}", eventName);
    }

    public static void submitFeedback(String eventName, String feedback) {
        logger.info("Feedback for {}: {}", eventName, feedback);
    }
}

