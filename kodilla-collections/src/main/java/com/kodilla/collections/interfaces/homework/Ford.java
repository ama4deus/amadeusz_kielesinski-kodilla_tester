package com.kodilla.collections.interfaces.homework;

public class Ford implements Car{

    private int speed;

    @Override
    public int getSpeed() {
        return speed;
    }

    @Override
    public void increaseSpeed() {
        speed = speed + 10;
    }

    @Override
    public void decreaseSpeed() {
        if (speed >= 8) {
            speed = speed - 8;
        } else {
            speed = 0;
        }
    }

}
