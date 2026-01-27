package com.kodilla.abstracts.homework;

public class ApplicationJob {


    public static void main(String[] args) {
        Postman postman = new Postman();
        Person person = new Person("Jan", 35, postman);
        person.displayResponsibilities();

    }
}
