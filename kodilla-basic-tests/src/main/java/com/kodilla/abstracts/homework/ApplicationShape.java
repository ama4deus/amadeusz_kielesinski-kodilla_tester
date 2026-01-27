package com.kodilla.abstracts.homework;

public class ApplicationShape {
    public static void main(String[] args) {

        System.out.println(" SHAPES ");


        Shape square = new Square(11);
        System.out.println("Square Area: " + square.calculateArea());
        System.out.println ("Square Perimeter: " + square.calculatePerimeter());

        Shape circle = new Circle(3.0);
        System.out.println("Circle Area: " + circle.calculateArea());
        System.out.println("Circle Perimeter: " + circle.calculatePerimeter());

        Shape triangle = new Triangle(6.0, 4.0, 5.0, 5.0);
        System.out.println("Triangle Area: " + triangle.calculateArea());
        System.out.println("Triangle Perimeter: " + triangle.calculatePerimeter());

        System.out.println();
    }
}