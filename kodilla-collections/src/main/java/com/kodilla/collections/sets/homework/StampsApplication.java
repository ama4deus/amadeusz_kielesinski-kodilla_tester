package com.kodilla.collections.sets.homework;

import java.util.HashSet;
import java.util.Set;

public class StampsApplication {
    public static void main(String[] args) {
        Set<Stamp> stamps = new HashSet<>();

        stamps.add(new Stamp("Gdańsk 1945", 2.5, 3.0, true));
        stamps.add(new Stamp("Warszawa", 2.0, 2.0, false));
        stamps.add(new Stamp("Kraków", 3.0, 2.5, false));
//ten sam znaczek
        stamps.add(new Stamp("Gdańsk 1945", 2.5, 3.0, true));
//prawie ten sam znaczek, ale nie ma stempla
        stamps.add(new Stamp("Gdańsk 1945", 2.5, 3.0, false));

        System.out.println("Liczba unikalnych znaczków w kolekcji: " + stamps.size());

        for (Stamp stamp : stamps) {
            System.out.println(stamp);
        }
    }
}