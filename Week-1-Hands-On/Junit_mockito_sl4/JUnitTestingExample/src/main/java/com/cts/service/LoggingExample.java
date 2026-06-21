package com.cts.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingExample {
    private static final Logger logger = LoggerFactory.getLogger(LoggingExample.class);
    public void executeLoggingShowcase(String studentName, String technicalTopic) {
        logger.error("CRITICAL ERROR: Failed to establish server socket connection.");
        logger.warn("SYSTEM WARNING: High memory footprint detected during execution loop.");
        logger.info("Application Status: Initializing execution sequence step.");
        logger.info("Technical Session Log: Mentor '{}' conducted a deep-dive workshop on '{}'.", studentName, technicalTopic);
    }
}