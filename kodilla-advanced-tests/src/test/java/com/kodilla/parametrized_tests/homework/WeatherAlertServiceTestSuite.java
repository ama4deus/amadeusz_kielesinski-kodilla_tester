package com.kodilla.parametrized_tests.homework;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class WeatherAlertServiceTestSuite {

    WeatherAlertService weatherService = new WeatherAlertService();
    Client client = Mockito.mock(Client.class);
    Client secondClient = Mockito.mock(Client.class);
    Notification notification = Mockito.mock(Notification.class);

    @BeforeEach
    public void clearService() {
        weatherService = new WeatherAlertService();
    }

    @Test
    public void shouldSendNotificationToSubscribedLocation() {
        weatherService.addSubscriber("Warszawa", client);
        weatherService.sendToLocation("Warszawa", notification);

        Mockito.verify(client, Mockito.times(1)).receive(notification);
    }

    @Test
    public void shouldNotReceiveNotificationFromOtherLocation() {
        weatherService.addSubscriber("Warszawa", client);
        weatherService.sendToLocation("Kraków", notification);

        Mockito.verify(client, Mockito.never()).receive(notification);
    }

    @Test
    public void shouldRemoveSubscriptionFromLocation() {
        weatherService.addSubscriber("Warszawa", client);
        weatherService.removeSubscriberFromLocation("Warszawa", client);
        weatherService.sendToLocation("Warszawa", notification);

        Mockito.verify(client, Mockito.never()).receive(notification);
    }

    @Test
    public void shouldRemoveSubscriberEverywhere() {
        weatherService.addSubscriber("Warszawa", client);
        weatherService.addSubscriber("Gdańsk", client);
        weatherService.removeSubscriberEverywhere(client);

        weatherService.sendToAll(notification);

        Mockito.verify(client, Mockito.never()).receive(notification);
    }

    @Test
    public void shouldSendNotificationToAllClients() {
        weatherService.addSubscriber("Warszawa", client);
        weatherService.addSubscriber("Kraków", secondClient);

        weatherService.sendToAll(notification);

        Mockito.verify(client, Mockito.times(1)).receive(notification);
        Mockito.verify(secondClient, Mockito.times(1)).receive(notification);
    }

    @Test
    public void shouldNotSendNotificationAfterLocationIsDeleted() {
        weatherService.addSubscriber("Warszawa", client);
        weatherService.deleteLocation("Warszawa");

        weatherService.sendToLocation("Warszawa", notification);

        Mockito.verify(client, Mockito.never()).receive(notification);
    }
}