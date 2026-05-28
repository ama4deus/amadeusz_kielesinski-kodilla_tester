package com.kodilla.collections.interfaces.homework;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CarRaceTestSuite {

    @Test
    void testFord() {
        Ford ford = new Ford();
        ford.increaseSpeed(); // speed = 10
        ford.increaseSpeed(); // speed = 20
        ford.decreaseSpeed(); // speed = 12
        assertEquals(12, ford.getSpeed());
    }

    @Test
    void testOpel() {
        Opel opel = new Opel();
        opel.increaseSpeed(); // speed = 7
        opel.decreaseSpeed(); // speed = 0 (bo 7 < 8)
        assertEquals(0, opel.getSpeed());
    }

    @Test
    void testToyota() {
        Toyota toyota = new Toyota();
        toyota.increaseSpeed(); // speed = 14
        toyota.decreaseSpeed(); // speed = 3 (14 - 11)
        assertEquals(3, toyota.getSpeed());
    }

    @Test
    void testCarRaceMain() {
        // To odhaczy klasę CarRace
        assertDoesNotThrow(() -> CarRace.main(new String[]{}));
    }
}