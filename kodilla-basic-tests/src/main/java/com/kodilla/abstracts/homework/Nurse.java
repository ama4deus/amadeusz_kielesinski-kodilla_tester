package com.kodilla.abstracts.homework;


public class Nurse extends Job {
    @Override
    public double salary() {
        return 5000.0;
    }

    @Override
    public String responsibilities() {
        return "Giving injections, patient care";
    }
}
