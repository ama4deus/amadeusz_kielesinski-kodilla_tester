package com.kodilla.inheritance;

public class OperatingSystem {
    private int releaseYear;

    public OperatingSystem(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public void turnOn() {
        System.out.println("System is turned on.");
    }

    public void turnOff() {
        System.out.println("System is turned off.");
    }


}
