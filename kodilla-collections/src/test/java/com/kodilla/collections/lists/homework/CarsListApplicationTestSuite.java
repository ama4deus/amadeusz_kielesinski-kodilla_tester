package com.kodilla.collections.lists.homework;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CarsListApplicationTestSuite {

    @Test
    void testMainMethod() {
        assertDoesNotThrow(() -> CarsListApplication.main(new String[]{}));
    }
}