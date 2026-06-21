package com.cts.service;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class EvenChecker {
    public boolean isEven(int number) {
        return number % 2 == 0;
    }
}

class ExceptionThrower {
    public void throwException() {
        throw new IllegalArgumentException("Invalid operation configuration argument data.");
    }
}

class PerformanceTester {
    public void performTask() throws InterruptedException {
        Thread.sleep(100); // Simulate processing latency
    }
}
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AdvancedJUnitTestSuite {
    @ParameterizedTest
    @ValueSource(ints = {2, 4, 12, 40, 88})
    @Order(1)
    public void testIsEvenWithTrueInputs(int number) {
        EvenChecker checker = new EvenChecker();
        assertTrue(checker.isEven(number));
    }
    @Test
    @Order(2)
    public void testExpectedException() {
        ExceptionThrower thrower = new ExceptionThrower();

        assertThrows(IllegalArgumentException.class, () -> {
            thrower.throwException();
        });
    }
    @Test
    @Order(3)
    public void testTaskExecutionTimeout() {
        PerformanceTester tester = new PerformanceTester();

        assertTimeout(Duration.ofMillis(500), () -> {
            tester.performTask();
        });
    }
}