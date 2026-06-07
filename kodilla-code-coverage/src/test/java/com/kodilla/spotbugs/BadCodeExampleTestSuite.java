package com.kodilla.spotbugs;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BadCodeExampleTestSuite {

    @Test
    void testBadCodeMethods() {
        assertEquals(Math.PI, BadCodeExample.getPi(), 0.001);

        BadCodeExample example1 = new BadCodeExample();
        BadCodeExample example2 = new BadCodeExample();

        example1.setType("A");
        example2.setType("A");

        assertEquals(example1, example2);
    }
}