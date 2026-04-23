package com.kodilla.parametrized_tests.homework;

import org.junit.jupiter.params.provider.Arguments;
import java.util.stream.Stream;

public class PersonSources {
    static Stream<Arguments> providePeopleForTestingBMI() {
        return Stream.of(
                Arguments.of(new Person(1.70, 40), "Very severely underweight"),
                Arguments.of(new Person(1.70, 45), "Severely underweight"),
                Arguments.of(new Person(1.70, 50), "Underweight"),
                Arguments.of(new Person(1.70, 70), "Normal (healthy weight)"),
                Arguments.of(new Person(1.70, 85), "Overweight"),
                Arguments.of(new Person(1.70, 95), "Obese Class I (Moderately obese)"),
                Arguments.of(new Person(1.70, 110), "Obese Class II (Severely obese)"),
                Arguments.of(new Person(1.70, 125), "Obese Class III (Very severely obese)"),
                Arguments.of(new Person(1.70, 140), "Obese Class IV (Morbidly Obese)"),
                Arguments.of(new Person(1.70, 160), "Obese Class V (Super Obese)"),
                Arguments.of(new Person(1.70, 200), "Obese Class VI (Hyper Obese)")
        );
    }
}