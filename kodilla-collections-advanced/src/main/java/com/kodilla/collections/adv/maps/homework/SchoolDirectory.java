package com.kodilla.collections.adv.maps.homework;

import java.util.HashMap;
import java.util.Map;

public class SchoolDirectory {
    public static void main(String[] args) {
        Map<Principal, School> schoolMap = new HashMap<>();

        Principal smith = new Principal("John", "Smith");
        Principal taylor = new Principal("Emily", "Taylor");
        Principal brown = new Principal("Robert", "Brown");

        School primary = new School("SP nr 5", 22, 25, 19, 21);
        School high = new School("Liceum Ogólnokształcące", 30, 32, 28);
        School technical = new School("Technikum Leśne", 15, 18, 17, 20, 22);

        // Przypisanie szkoły do dyrektorów
        schoolMap.put(smith, primary);
        schoolMap.put(taylor, high);
        schoolMap.put(brown, technical);

        // Wyświetlanie
        for (Map.Entry<Principal, School> entry : schoolMap.entrySet()) {
            Principal principal = entry.getKey();
            School school = entry.getValue();

            System.out.println("Dyrektor: " + principal +
                    " | Szkoła: " + school.getName() +
                    " | Razem uczniów: " + school.getSum());
        }
    }
}