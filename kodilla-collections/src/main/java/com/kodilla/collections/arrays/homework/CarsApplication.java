package com.kodilla.collections.arrays.homework;

import com.kodilla.collections.interfaces.homework.Car;
import com.kodilla.collections.interfaces.homework.Ford;
import com.kodilla.collections.interfaces.homework.Opel;
import com.kodilla.collections.interfaces.homework.Toyota;

import java.util.Random;

public class CarsApplication {
    private static final Random RANDOM = new Random();

    public static Car drawCar() {
        int drawnCarBrand = RANDOM.nextInt(3); // Losuje 0, 1 lub 2
        Car car;

        if (drawnCarBrand == 0) {
            car = new Ford();
        } else if (drawnCarBrand == 1) {
            car = new Opel();
        } else {
            car = new Toyota();
        }

        // Losujemy ile razy auto ma przyspieszyć (np. od 1 do 10 razy)
        int timesToIncrease = RANDOM.nextInt(10) + 1;
        for (int i = 0; i < timesToIncrease; i++) {
            car.increaseSpeed();
        }

        return car;
    }

    public static void main(String[] args) {
        // Tablica o losowym rozmiarze od 1 do 15
        int arraySize = RANDOM.nextInt(15) + 1;
        Car[] cars = new Car[arraySize];

        // Wypełnianie tablicy
        for (int i = 0; i < cars.length; i++) {
            cars[i] = drawCar();
        }

        // Wyświetlanie wyników pętlą "for-each"
        for (Car car : cars) {
            CarUtils.describeCar(car);
        }
    }
}