package com.kodilla.inheritance;

public class OperatingSystemApp {
    public static void main(String[] args) {
        SystemX systemX = new SystemX(2023);
        systemX.turnOn();
        systemX.turnOff();
        SystemY systemY = new SystemY(2024);
        systemY.turnOn();
        systemY.turnOff();
    }
}
