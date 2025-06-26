package com.example1.project1;





import org.apache.logging.log4j.LogManager;

//import org.apache.logging.log4j.Logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserServiceLog {

//    private static final Logger logger = LogManager.getLogger(UserServiceLog.class);
//
//    public static void main(String[] args) {
//        registerUser("athithya123");
//        loginUser("athithya123", true);
//        loginUser("unknownUser", false);
//        deleteUser("athithya123");
//    }
//
//    public static void registerUser(String username) {
//        logger.info("New user registration: {}", username);
//    }
//
//    public static void loginUser(String username, boolean success) {
//        if (success) {
//            logger.debug("Login successful for user: {}", username);
//        } else {
//            logger.warn("Login failed for user: {}", username);
//        }
//    }
//
//    public static void deleteUser(String username) {
//        try {
//            logger.info("User deleted: {}", username);
//        } catch (Exception e) {
//            logger.error("Error while deleting user: {}", username, e);
//        }
//    }
	
	private static final Logger logger = LoggerFactory.getLogger(UserServiceLog.class);

    public static void main(String[] args) {
        logger.info("UserLogger started...");
        registerUser("ab123");
        loginUser("ab123", true);
        loginUser("unknown", false);
        deleteUser("ab123");
    }

    public static void registerUser(String username) {
        logger.info("User registered: {}", username);
    }

    public static void loginUser(String username, boolean success) {
        if (success) {
            logger.debug("Login successful for user: {}", username);
        } else {
            logger.warn("Login failed for user: {}", username);
        }
    }

    public static void deleteUser(String username) {
        logger.info("User deleted: {}", username);
    }
	
	
}
