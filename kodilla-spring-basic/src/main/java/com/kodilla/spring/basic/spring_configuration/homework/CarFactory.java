package com.kodilla.spring.basic.spring_configuration.homework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.time.LocalTime;
import java.time.MonthDay;

@Configuration
public class CarFactory {

    @Bean
    public Car pickCar() {
        Car car;
        MonthDay now = MonthDay.now();
        LocalTime time = LocalTime.now();

        boolean lightsOn = time.isAfter(LocalTime.of(19, 59)) || time.isBefore(LocalTime.of(6, 1));

        if (isSummer(now)) {
            car = new Cabrio(lightsOn);
        } else if (isWinter(now)) {
            car = new SUV(lightsOn);
        } else {
            car = new Sedan(lightsOn);
        }
        return car;
    }

    private boolean isSummer(MonthDay date) {
        return date.isAfter(MonthDay.of(6, 20)) && date.isBefore(MonthDay.of(9, 24));
    }

    private boolean isWinter(MonthDay date) {
        return date.isAfter(MonthDay.of(12, 20)) || date.isBefore(MonthDay.of(3, 21));
    }
}