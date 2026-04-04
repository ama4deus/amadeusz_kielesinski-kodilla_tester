package com.kodilla.collections.lists.homework;

import com.kodilla.collections.interfaces.homework.Car;
import com.kodilla.collections.interfaces.homework.Ford;
import com.kodilla.collections.interfaces.homework.Opel;
import com.kodilla.collections.interfaces.homework.Toyota;
import com.kodilla.collections.arrays.homework.CarUtils;

import java.util.ArrayList;
import java.util.List;

public class CarsListApplication {
    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();

        Ford myFord = new Ford();
        myFord.increaseSpeed();

        Opel opel = new Opel();
        opel.increaseSpeed();

        Toyota toyota = new Toyota();
        toyota.increaseSpeed();

        cars.add(myFord);
        cars.add(opel);
        cars.add(toyota);
        cars.add(new Ford());

        System.out.println("Zawartość listy przed usuwaniem:");
        for (Car car : cars) {
            CarUtils.describeCar(car);
        }

        cars.remove(1);

        cars.remove(myFord);

        System.out.println("\nPo usunięciu dwóch aut:");
        for (Car car : cars) {
            CarUtils.describeCar(car);
        }

        System.out.println("\nRozmiar końcowy: " + cars.size());
    }
}
