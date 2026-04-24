package com.kodilla.parametrized_tests.homework;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserValidatorTest {

    private UserValidator validator = new UserValidator();


    @ParameterizedTest
    @ValueSource(strings = {"Amadeusz", "User_123", "a.b-c_"})
    public void shouldReturnTrueIfUsernameIsValid(String username) {
        assertTrue(validator.validateUsername(username));
    }

    @ParameterizedTest
    @ValueSource(strings = {"ab", "a!", "user name"})
    @NullAndEmptySource
    public void shouldReturnFalseIfUsernameIsInvalid(String username) {
        assertFalse(validator.validateUsername(username));
    }


    @ParameterizedTest
    @ValueSource(strings = {
            "test@gmail.com",
            "user.name@company.pl",
            "amadeusz@sub.domain.com.pl"
    })
    public void shouldReturnTrueIfEmailIsValid(String email) {
        assertTrue(validator.validateEmail(email));
    }

    @ParameterizedTest
    @ValueSource(strings = {"test@gmail", "user@", "@domain.com", "user name@domain.com"})
    @NullAndEmptySource
    public void shouldReturnFalseIfEmailIsInvalid(String email) {
        assertFalse(validator.validateEmail(email));
    }
}