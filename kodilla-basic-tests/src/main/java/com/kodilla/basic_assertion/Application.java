package com.kodilla.basic_assertion;

public class Application {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int a = 5;
        int b = 8;
        int n = 3;

        int sumResult = calculator.sum(a, b);
        boolean correctSum = ResultChecker.assertEquals(13, sumResult);
        if (correctSum) {
            System.out.println("Metoda sum działa poprawnie dla liczb " + a + " i " + b);
        } else {
            System.out.println("Metoda sum nie działa poprawnie dla liczb " + a + " i " + b);
        }
        int subtractResult = calculator.subtract(b, a);
        boolean correctSub = ResultChecker.assertEquals(3, subtractResult);
        if (correctSub) {
            System.out.println("Metoda odejmowania działa poprawnie dla liczb " + b + " i " + a);
        } else {
            System.out.println("Metoda odejmowania nie działa poprawnie dla liczb " + b + " i " + a);
        }
        int squareResult = calculator.square(n);
        boolean correctSquare = ResultChecker.assertEquals(9, squareResult);
        if (correctSquare) {
            System.out.println("Metoda square działa poprawnie dla liczby " + n );
        } else {
            System.out.println("Metoda square nie działa poprawnie dla liczby " + n);
        }

    }
}
