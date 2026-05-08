package com.kodilla.spring.basic.spring_scopes.homework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootTest
public class ClockTestSuite {

    @Test
    void shouldCreateDifferentClocks() throws InterruptedException {
        // Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring.basic.spring_scopes.homework");

        // When
        Clock firstClock = context.getBean(Clock.class);
        Thread.sleep(10); // Czekamy 10ms
        Clock secondClock = context.getBean(Clock.class);
        Thread.sleep(10);
        Clock thirdClock = context.getBean(Clock.class);

        // Then
        Assertions.assertNotEquals(firstClock, secondClock);
        Assertions.assertNotEquals(secondClock, thirdClock);

        Assertions.assertNotEquals(firstClock.getTime(), secondClock.getTime());
        Assertions.assertNotEquals(secondClock.getTime(), thirdClock.getTime());

        System.out.println("Time 1: " + firstClock.getTime());
        System.out.println("Time 2: " + secondClock.getTime());
        System.out.println("Time 3: " + thirdClock.getTime());
    }
}