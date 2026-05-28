package com.kodilla.spotbugs;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BadCodeExampleTestSuite {

    @Test
    void testBadCodeMethods() {
        assertEquals(3.14, BadCodeExample.getPi());

        BadCodeExample example1 = new BadCodeExample();
        assertNull(example1.getType());

        BadCodeExample example2 = new BadCodeExample();

        assertTrue(example1.equals(example1)); // to samo
        assertTrue(example1.equals(example2)); // różne obiekty, oba z null type
        assertFalse(example1.equals(null));    // porównanie z null
    }
}