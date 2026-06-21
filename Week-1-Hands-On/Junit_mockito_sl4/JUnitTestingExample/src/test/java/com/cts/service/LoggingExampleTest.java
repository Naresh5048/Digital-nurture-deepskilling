package com.cts.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoggingExampleTest {

    @Test
    public void testLoggingFrameworkFlow() {
        LoggingExample loggingExample = new LoggingExample();
        assertDoesNotThrow(() -> {
            loggingExample.executeLoggingShowcase("Naresh Challa", "SLF4J Parameterized Logging");
        });
    }
}