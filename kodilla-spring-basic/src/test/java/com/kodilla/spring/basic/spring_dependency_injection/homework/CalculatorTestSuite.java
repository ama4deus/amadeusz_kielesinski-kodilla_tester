package com.kodilla.spring.basic.spring_dependency_injection.homework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootTest
public class CalculatorTestSuite {

    @Test
    public void shouldAddValues() {
        // Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring.basic"); //
        Calculator calculator = context.getBean(Calculator.class); //

        // When
        double result = calculator.add(10.5, 5.5);

        // Then
        Assertions.assertEquals(16.0, result, 0.01); //
    }

    @Test
    public void shouldSubtractValues() {
        // Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring.basic");
        Calculator calculator = context.getBean(Calculator.class);

        // When
        double result = calculator.subtract(10.5, 5.5);

        // Then
        Assertions.assertEquals(5.0, result, 0.01);
    }

    @Test
    public void shouldMultiplyValues() {
        // Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring.basic");
        Calculator calculator = context.getBean(Calculator.class);

        // When
        double result = calculator.multiply(10.0, 5.0);

        // Then
        Assertions.assertEquals(50.0, result, 0.01);
    }

    @Test
    public void shouldDivideValues() {
        // Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring.basic");
        Calculator calculator = context.getBean(Calculator.class);

        // When
        double result = calculator.divide(10.0, 5.0);

        // Then
        Assertions.assertEquals(2.0, result, 0.01);
    }
}