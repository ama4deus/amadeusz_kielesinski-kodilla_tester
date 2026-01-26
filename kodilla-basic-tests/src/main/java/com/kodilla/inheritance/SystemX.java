package com.kodilla.inheritance;


public class SystemX extends OperatingSystem {
    public SystemX(int releaseYear) {
        super(releaseYear);
    }

    @Override
    public void turnOn() {
        System.out.println("SystemX is turned on.");
    }
    @Override
    public void turnOff() {
        System.out.println("SystemX is turned off.");
    }

}