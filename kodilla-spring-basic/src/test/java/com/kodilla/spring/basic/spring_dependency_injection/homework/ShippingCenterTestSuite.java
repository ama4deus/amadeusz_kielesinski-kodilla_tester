package com.kodilla.spring.basic.spring_dependency_injection.homework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootTest
public class ShippingCenterTestSuite {

    @Test
    public void shouldReturnSuccessMessageWhenWeightIsCorrect() {
        // Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring.basic.spring_dependency_injection.homework");
        ShippingCenter shippingCenter = context.getBean(ShippingCenter.class);

        // When
        String result = shippingCenter.sendPackage("Warsaw, ul. Sezamkowa 1", 25.0);

        // Then
        Assertions.assertEquals("Package delivered to: Warsaw, ul. Sezamkowa 1", result);
    }

    @Test
    public void shouldReturnFailMessageWhenPackageIsTooHeavy() {
        // Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring.basic.spring_dependency_injection.homework");
        ShippingCenter shippingCenter = context.getBean(ShippingCenter.class);

        // When
        String result = shippingCenter.sendPackage("Warsaw, ul. Sezamkowa 1", 35.0);

        // Then
        Assertions.assertEquals("Package not delivered to: Warsaw, ul. Sezamkowa 1", result);
    }
}