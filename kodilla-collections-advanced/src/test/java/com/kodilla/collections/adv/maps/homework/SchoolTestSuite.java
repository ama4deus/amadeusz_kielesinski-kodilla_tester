package com.kodilla.collections.adv.maps.homework;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SchoolTestSuite {
    @Test
    void testSchoolSum() {
        School school = new School("Test School", 10, 20);
        assertEquals(30, school.getSum());
    }

    @Test
    void testDirectoryMain() {
        // Odhacza klasę SchoolDirectory
        assertDoesNotThrow(() -> SchoolDirectory.main(new String[]{}));
    }
}