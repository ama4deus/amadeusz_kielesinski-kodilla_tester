package com.kodilla.spring.basic.spring_configuration.homework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class CarFactoryTestSuite {

    @Test
    void shouldPickCarDependingOnSeason() {
        // Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring.basic.spring_configuration.homework");
        Car car = (Car) context.getBean("pickCar");

        // When
        String type = car.getCarType();
        boolean lights = car.hasHeadlightsTurnedOn();

        System.out.println("Picked car type: " + type);
        System.out.println("Lights on: " + lights);

        // Then
        List<String> possibleTypes = Arrays.asList("SUV", "Cabrio", "Sedan");
        Assertions.assertTrue(possibleTypes.contains(type));
    }

    @Test
    void shouldHaveLightsTurnedOnOrOffDependingOnTime() {
        // Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring.basic.spring_configuration.homework");
        Car car = context.getBean(Car.class);

        // When
        boolean lights = car.hasHeadlightsTurnedOn();
        String type = car.getCarType();

        // Then
        System.out.println("Testing " + type + " - Lights are on: " + lights);

        Assertions.assertNotNull(lights);
    }
}