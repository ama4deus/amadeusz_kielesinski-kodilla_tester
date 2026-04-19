package com.kodilla.collections.sets.homework;

import java.util.HashSet;
import java.util.Set;

public class StampsApplication {
    public static void main(String[] args) {
        Set<Stamp> stamps = new HashSet<>();

        stamps.add(new Stamp("Gdańsk 1945", 2.5, 3.0, true));
        stamps.add(new Stamp("Warszawa", 2.0, 2.0, false));
        stamps.add(new Stamp("Kraków", 3.0, 2.5, false));
        // Ten sam znaczek
        stamps.add(new Stamp("Gdańsk 1945", 2.5, 3.0, true));
        // Prawie ten sam znaczek
        stamps.add(new Stamp("Gdańsk 1945", 2.5, 3.0, false));

        System.out.println("=== TEST KOLEKCJI ZNACZKÓW ===");
        System.out.println("Próbowano dodać 5 znaczków (w tym 1 identyczny duplikat).");
        System.out.println("Oczekiwana liczba unikalnych elementów: 4");
        System.out.println("Faktyczna liczba unikalnych elementów: " + stamps.size());

        if (stamps.size() == 4) {
            System.out.println("TEST ZALICZONY: Set poprawnie obsłużył duplikaty.");
        } else {
            System.out.println("TEST NIEZALICZONY: Rozmiar kolekcji jest inny niż oczekiwany!");
        }

        System.out.println("\nLista znaczków w kolekcji:");
        for (Stamp stamp : stamps) {
            System.out.println(stamp);
        }
    }
}