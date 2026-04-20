package com.kodilla.optional.homework;

public class Teacher {
    private String name; // Najpierw definiujemy, co klasa przechowuje

    public Teacher(String name) { // Potem konstruktor, który to ustawia
        this.name = name;
    }

    public String getName() { // Na końcu gettery
        return name;
    }
}