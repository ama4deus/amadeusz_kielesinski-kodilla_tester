package com.kodilla.spring.basic.spring_configuration.homework;

public class SUV implements Car {
    private boolean lightsOn;

    public SUV(boolean lightsOn) {
        this.lightsOn = lightsOn;
    }

    @Override
    public boolean hasHeadlightsTurnedOn() {
        return lightsOn;
    }

    @Override
    public String getCarType() {
        return "SUV";
    }
}