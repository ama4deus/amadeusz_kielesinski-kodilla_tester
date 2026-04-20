package com.kodilla.collections.adv.exercises.homework;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FlightFinderTest {

    @Test
    void findFlightsFrom() {
        // Given
        FlightFinder finder = new FlightFinder();

        // When
        List<Flight> result = finder.findFlightsFrom("Honolulu");

        // Then
        assertEquals(1, result.size());
    }

    @Test
    void findFlightsTo() {
        // Given
        FlightFinder finder = new FlightFinder();

        // When
        List<Flight> result = finder.findFlightsTo("Tokyo");

        // Then
        assertEquals(1, result.size());
    }

    @Test
    void testFindFlightsFromNonExistentCity() {
        // Given
        FlightFinder finder = new FlightFinder();

        // When
        List<Flight> result = finder.findFlightsFrom("Częstochowa");

        // Then
        assertNotNull(result);
        assertEquals(0, result.size());
    }

    @Test
    void testFindFlightsToNonExistentCity() {
        // Given
        FlightFinder finder = new FlightFinder();

        // When
        List<Flight> result = finder.findFlightsTo("Sosnowiec");

        // Then
        assertNotNull(result);
        assertEquals(0, result.size());
    }

}