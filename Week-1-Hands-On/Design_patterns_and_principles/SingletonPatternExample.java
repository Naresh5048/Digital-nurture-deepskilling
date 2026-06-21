package com.cts.exercise01_singleton;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class Logger {
    private static volatile Logger instance;

    private Logger() {
        if (instance != null) {
            throw new IllegalStateException();
        }
    }
    public static Logger getInstance() {
        if (instance == null) {
            synchronized (Logger.class) {
                if (instance == null) {
                    instance = new Logger();
                }
            }
        }
        return instance;
    }
    public void log(String message) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        String timestamp = LocalDateTime.now().format(formatter);
        System.out.println("[" + timestamp + "] [INFO] " + message);
    }
}

public class SingletonPatternExample {
    public static void main(String[] args) {
        System.out.println("=== Running Singleton Pattern Validation ===");

        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        logger1.log("Initializing core application modules...");
        logger2.log("Connecting securely to database instance...");
        System.out.println(" Identity Check");
        System.out.println("Logger 1 HashCode: " + logger1.hashCode());
        System.out.println("Logger 2 HashCode: " + logger2.hashCode());
        if (logger1 == logger2) {
            System.out.println("SUCCESS: Both references point to the exact same instance.");
        } else {
            System.out.println("FAILURE: Different instances found!");
        }
    }
}