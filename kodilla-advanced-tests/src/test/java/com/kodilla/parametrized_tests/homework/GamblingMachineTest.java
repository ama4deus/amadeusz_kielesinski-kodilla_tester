package com.kodilla.parametrized_tests.homework;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import java.util.HashSet;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;

class GamblingMachineTest {
    private GamblingMachine gamblingMachine = new GamblingMachine();

    @ParameterizedTest
    @CsvFileSource(resources = "/gambling_numbers.csv")
    void shouldReturnCorrectWinCountForValidNumbers(
            int n1, int n2, int n3, int n4, int n5, int n6) throws InvalidNumbersException {

        Set<Integer> userNumbers = new HashSet<>();
        userNumbers.add(n1);
        userNumbers.add(n2);
        userNumbers.add(n3);
        userNumbers.add(n4);
        userNumbers.add(n5);
        userNumbers.add(n6);

        int result = gamblingMachine.howManyWins(userNumbers);

        assertTrue(result >= 0 && result <= 6);
    }
}