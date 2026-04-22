package com.kodilla.parametrized_tests.homework;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class UserValidatorTest {

    private UserValidator validator = new UserValidator();

    @ParameterizedTest
    @ValueSource(strings = {"user123", "ABC", "john.doe", "mike_88", "admin-1"})
    void shouldReturnTrueForValidUsernames(String username) {
        assertTrue(validator.validateUsername(username));
    }

    @ParameterizedTest
    @ValueSource(strings = {"ab", "a!", "user name", " "})
    void shouldReturnFalseForInvalidUsernames(String username) {
        assertFalse(validator.validateUsername(username));
    }

    @ParameterizedTest
    @NullSource
    void shouldReturnFalseForNullUsername(String username) {
        assertFalse(validator.validateUsername(username));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "test@gmail.com, true",
            "admin@kodilla.pl, true",
            "user.name@company.org, true",
            "a@b.c, true",
            "plainaddress, false",
            "#@%^%#$@#$@#.com, false",
            "@example.com, false",
            "joe smith@example.com, false",
            "email.example.com, false",
            "email@example@example.com, false",
            "email@example, false"
    })
    void shouldValidateEmail(String email, boolean expected) {
        assertEquals(expected, validator.validateEmail(email));
    }

    @ParameterizedTest
    @NullAndEmptySource
    void shouldReturnFalseForNullOrEmptyEmail(String email) {
        assertFalse(validator.validateEmail(email));
    }
}