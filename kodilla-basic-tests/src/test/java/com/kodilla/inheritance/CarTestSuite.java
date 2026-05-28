package com.kodilla.inheritance;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CarTestSuite {
    @Test
    void testConvertible() {
        // Testowanie konstruktorów
        Convertible conv1 = new Convertible();
        Convertible conv2 = new Convertible(4, 2);

        // Testowanie metod z Convertible
        conv1.openRoof();
        conv1.closeRoof();

        // Testowanie metody nadpisanej
        conv1.openDoors();

        // Sprawdzenie, czy super(wheels, seats) działa poprawnie
        assertEquals(4, conv2.getWheels());
        assertEquals(2, conv2.getSeats());
    }
}