package com.kodilla.parametrized_tests.homework;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BMITest {

    @ParameterizedTest
    @MethodSource(value = "com.kodilla.parametrized_tests.homework.PersonSources#providePeopleForTestingBMI")
    void shouldCalculateCorrectBMI(Person person, String expectedBMI) {
        assertEquals(expectedBMI, person.getBMI());
    }
}