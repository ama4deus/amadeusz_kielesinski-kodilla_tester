package com.kodilla.spring.basic.spring_dependency_injection.homework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CalculatorTestSuite {

    @Autowired
    private Calculator calculator;

    @Test
    public void shouldAdd() {
        double result = calculator.add(10, 5);
        Assertions.assertEquals(15, result);
    }

    @Test
    public void shouldSubtract() {
        double result = calculator.subtract(10, 5);
        Assertions.assertEquals(5, result);
    }

    @Test
    public void shouldMultiply() {
        double result = calculator.multiply(10, 5);
        Assertions.assertEquals(50, result);
    }

    @Test
    public void shouldDivide() {
        double result = calculator.divide(10, 5);
        Assertions.assertEquals(2, result);
    }

    @Test
    public void shouldHandleDivisionByZero() {
        Assertions.assertThrows(ArithmeticException.class, () -> calculator.divide(10, 0));
    }
}