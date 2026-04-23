package com.kodilla.parametrized_tests.homework;

import java.util.*;

public class WeatherAlertService {
    private Map<String, Set<Client>> locationSubscribers = new HashMap<>();

    // Dodanie subskrypcji do lokalizacji
    public void addSubscriber(String location, Client client) {
        this.locationSubscribers.computeIfAbsent(location, k -> new HashSet<>()).add(client);
    }

    // Wycofanie subskrypcji z danej lokalizacji
    public void removeSubscriberFromLocation(String location, Client client) {
        if (this.locationSubscribers.containsKey(location)) {
            this.locationSubscribers.get(location).remove(client);
        }
    }

    // Wycofanie subskrypcji ze wszystkich lokalizacji (całkowite wypisanie)
    public void removeSubscriberEverywhere(Client client) {
        this.locationSubscribers.values().forEach(set -> set.remove(client));
    }

    // Wysyłka do osób w konkretnej lokalizacji
    public void sendToLocation(String location, Notification notification) {
        if (this.locationSubscribers.containsKey(location)) {
            this.locationSubscribers.get(location).forEach(client -> client.receive(notification));
        }
    }

    // Wysyłka do wszystkich osób (globalna)
    public void sendToAll(Notification notification) {
        Set<Client> allUniqueClients = new HashSet<>();
        this.locationSubscribers.values().forEach(allUniqueClients::addAll);
        allUniqueClients.forEach(client -> client.receive(notification));
    }

    // Skasowanie lokalizacji
    public void deleteLocation(String location) {
        this.locationSubscribers.remove(location);
    }
}