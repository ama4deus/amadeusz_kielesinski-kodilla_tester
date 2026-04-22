package com.kodilla.optional.homework;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        Teacher t1 = new Teacher("Tomasz Nowak");

        students.add(new Student("Jan Kowalski", t1));
        students.add(new Student("Ania Bania", null));

        for (Student student : students) {
            System.out.println("uczeń: " + student.getName() +
                    ", nauczyciel: " + student.getTeacherName());
        }
    }
}