package com.kodilla.basic_assertion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTestSuite {

    @Test
    public void testSum() {
        Calculator calculator = new Calculator();
        double a = 5.0;
        double b = 8.0;
        double sumResult = calculator.sum(a, b);
        assertEquals(13.0, sumResult, 0.01); // 0.01 to nasza delta
    }
    @Test
    public void testSubtract() {
        Calculator calculator = new Calculator();
        double a = 8.0;
        double b = 5.0;
        double subtractResult = calculator.subtract(a, b);
        assertEquals(3, subtractResult, 0.01);
    }
    @Test
    public void testSquare() {
        Calculator calculator = new Calculator();

        // Case: liczba większa od zera
        double positive = 5.0;
        assertEquals(25.0, calculator.square(positive), 0.01);

        // Case: zero
        double zero = 0.0;
        assertEquals(0.0, calculator.square(zero), 0.01);

        // Case: liczba mniejsza od zera
        double negative = -5.0;
        assertEquals(25.0, calculator.square(negative), 0.01);
    }
    @Test
    void testResultChecker() {
        boolean result = ResultChecker.assertEquals(10, 10);
        assertEquals(true, result);

        boolean failResult = ResultChecker.assertEquals(10, 5);
        assertEquals(false, failResult);
    }
}