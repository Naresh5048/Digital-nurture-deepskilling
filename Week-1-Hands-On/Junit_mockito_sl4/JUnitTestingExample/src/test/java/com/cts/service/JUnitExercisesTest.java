package com.cts.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class JUnitExercisesTest {

    private Calculator calc;
    @BeforeEach
    public void setUp() {
        calc = new Calculator();
        System.out.println("[Lifecycle Hook] @BeforeEach: Initialized fresh Calculator instance.");
    }
    @AfterEach
    public void tearDown() {
        calc = null;
        System.out.println("[Lifecycle Hook] @AfterEach: Cleared resources reference.");
    }
    @Test
    public void testAdditionBasic() {
        int input1 = 10;
        int input2 = 20;
        int result = calc.add(input1, input2);
        assertEquals(30, result);
    }

    @Test
    public void testSubtractionBasic() {
        // Arrange
        int input1 = 50;
        int input2 = 15;
        int result = calc.subtract(input1, input2);
        assertEquals(35, result);
    }
    @Test
    public void testAssertionsSuite() {
        assertEquals(5, calc.add(2, 3));
        assertTrue(calc.isEven(4));
        assertFalse(calc.isEven(7));
        assertNull(calc.getDatabaseConnectionToken(false));
        assertNotNull(calc.getDatabaseConnectionToken(true));
    }
}