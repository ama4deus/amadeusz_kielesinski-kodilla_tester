package com.kodilla.inheritance;


public class SystemY extends OperatingSystem {
    public SystemY(int releaseYear) {
        super(releaseYear);
    }

    @Override
    public void turnOn() {
        System.out.println("SystemY is turned on.");
    }
    @Override
    public void turnOff() {
        System.out.println("SystemY is turned off.");
    }

}