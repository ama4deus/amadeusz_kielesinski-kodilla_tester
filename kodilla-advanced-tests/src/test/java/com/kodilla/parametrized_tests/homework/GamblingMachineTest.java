package com.kodilla.parametrized_tests.homework;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

public class GamblingMachineTest {

    private GamblingMachine gamblingMachine;

    @BeforeEach
    public void setUp() {
        gamblingMachine = new GamblingMachine();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/gambling_numbers.csv", numLinesToSkip = 1)
    public void shouldCheckGamblingNumbersFromCsv(String input) {
        // Given
        Set<Integer> numbers = convertToSet(input);

        if (numbers.size() != 6 || isAnyOutOfRange(numbers)) {
            // Then
            assertThrows(InvalidNumbersException.class, () -> gamblingMachine.howManyWins(numbers));
        } else {
            // Then
            try {
                int result = gamblingMachine.howManyWins(numbers);
                assertTrue(result >= 0 && result <= 6);
            } catch (InvalidNumbersException e) {
                fail("Should not throw exception for valid numbers: " + input);
            }
        }
    }

    private boolean isAnyOutOfRange(Set<Integer> numbers) {
        return numbers.stream().anyMatch(n -> n < 1 || n > 49);
    }

    private Set<Integer> convertToSet(String input) {
        String[] elements = input.split(",");
        Set<Integer> numbers = new HashSet<>();
        for (String element : elements) {
            numbers.add(Integer.parseInt(element.trim()));
        }
        return numbers;
    }
}