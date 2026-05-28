package com.kodilla.collections.arrays.homework;

import com.kodilla.collections.interfaces.homework.Car;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CarsApplicationTestSuite {

    @Test
    void testDrawCar() {
        for (int i = 0; i < 10; i++) {
            Car car = CarsApplication.drawCar();
            assertNotNull(car);
            assertTrue(car.getSpeed() > 0);
        }
    }

    @Test
    void testMainMethod() {
        assertDoesNotThrow(() -> CarsApplication.main(new String[]{}));
    }
}