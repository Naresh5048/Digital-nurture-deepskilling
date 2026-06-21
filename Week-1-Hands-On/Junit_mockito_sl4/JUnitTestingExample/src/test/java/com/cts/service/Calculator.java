package com.cts.service;

public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }
    public int subtract(int a, int b) {
        return a - b;
    }
    public boolean isEven(int number) {
        return number % 2 == 0;
    }
    public Object getDatabaseConnectionToken(boolean isValid) {
        if (isValid) {
            return new Object();
        }
        return null;
    }
}