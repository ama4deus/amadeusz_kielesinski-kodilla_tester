package com.kodilla.collections.adv.maps.homework;

import java.util.ArrayList;
import java.util.List;

public class School {
    private String name;
    private List<Integer> classSizes = new ArrayList<>();

    public School(String name, Integer... students) {
        this.name = name;
        for (Integer count : students) {
            this.classSizes.add(count);
        }
    }

    public int getSum() {
        int sum = 0;
        for (int size : classSizes) {
            sum += size;
        }
        return sum;
    }

    public String getName() {
        return name;
    }
}