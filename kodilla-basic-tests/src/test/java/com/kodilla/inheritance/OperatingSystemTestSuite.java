package com.kodilla.inheritance;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OperatingSystemTestSuite {
    @Test
    void testSystems() {
        SystemX sysX = new SystemX(2023);
        SystemY sysY = new SystemY(2024);

        sysX.turnOn();
        sysX.turnOff();

        sysY.turnOn();
        sysY.turnOff();


        assertNotNull(sysX);
        assertNotNull(sysY);
    }

    @Test
    void testMainMethod() {
        assertDoesNotThrow(() -> OperatingSystemApp.main(new String[]{}));
    }
}