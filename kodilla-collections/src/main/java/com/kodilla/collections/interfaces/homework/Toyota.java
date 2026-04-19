package com.kodilla.collections.interfaces.homework;

public class Toyota implements Car {

    private int speed;

    @Override
    public int getSpeed() {
        return speed;
    }

    @Override
    public void increaseSpeed() {
        speed = speed + 14;
    }

    @Override
    public void decreaseSpeed() {
        if (speed >= 11) {
            speed = speed - 11;
        } else {
            speed = 0;
        }
    }


}


