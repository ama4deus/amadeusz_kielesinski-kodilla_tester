package com.kodilla.parametrized_tests;

public class StringManipulator {

    public String reverseWithLowerCase(String input) {
        StringBuilder builder = new StringBuilder(input);
        return builder.reverse().toString().toLowerCase();
    }

    public int calculateStringLengthWithoutSpaces(String input) {
        if (input == null) {
            return 0;
        }
        return input.replaceAll(" ", "").length();
    }
}