package com.kodilla.jacoco;

public class Year {

    private final int yearValue;

    public Year(int year) {
        this.yearValue = year;
    }

    public boolean isLeap() {
        return (yearValue % 4 == 0 && yearValue % 100 != 0) || (yearValue % 400 == 0);
    }
}