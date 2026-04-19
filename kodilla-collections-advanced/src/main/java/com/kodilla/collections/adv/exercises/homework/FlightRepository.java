package com.kodilla.collections.adv.exercises.homework;

import java.util.ArrayList;
import java.util.List;

public class FlightRepository {

    public static List<Flight> getFlightsTable() {
        // 1. To jest lista.
        List<Flight> flights = new ArrayList<>();

        // 2. Dodawanie nowych instancji lotu.
        flights.add(new Flight("Warsaw", "London"));
        flights.add(new Flight("Cracow", "Paris"));
        flights.add((new Flight("Honolulu", "Tokyo")));
        flights.add((new Flight("Washington", "Moscow")));
        flights.add((new Flight("New York", "Kyoto")));

        // 3. Zwracanie listy.
        return flights;
    }
}
