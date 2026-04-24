package com.kodilla.parametrized_tests.homework;

import org.junit.jupiter.params.provider.Arguments;
import java.util.stream.Stream;

public class PersonSources {

    static Stream<Arguments> provideDataForBmiTest() {
        return Stream.of(
                Arguments.of(new Person(1.70, 40.0), "Very severely underweight"),
                Arguments.of(new Person(1.70, 45.0), "Severely underweight"),
                Arguments.of(new Person(1.70, 50.0), "Underweight"),
                Arguments.of(new Person(1.70, 65.0), "Normal (healthy weight)"),
                Arguments.of(new Person(1.70, 80.0), "Overweight"),
                Arguments.of(new Person(1.80, 60.0), "Normal (healthy weight)"),
                Arguments.of(new Person(1.80, 59.9), "Underweight"),
                Arguments.of(new Person(1.60, 100.0), "Obese Class II (Severely obese)"),
                Arguments.of(new Person(2.00, 100.0), "Overweight")
        );
    }
}