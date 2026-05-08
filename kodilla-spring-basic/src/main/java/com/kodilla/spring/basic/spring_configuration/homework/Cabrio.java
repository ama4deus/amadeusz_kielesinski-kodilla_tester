package com.kodilla.spring.basic.spring_configuration.homework;

public class Cabrio implements Car {
    private boolean lightsOn;

    public Cabrio(boolean lightsOn) {
        this.lightsOn = lightsOn;
    }

    @Override
    public boolean hasHeadlightsTurnedOn() {
        return lightsOn;
    }

    @Override
    public String getCarType() {
        return "Cabrio";
    }
}