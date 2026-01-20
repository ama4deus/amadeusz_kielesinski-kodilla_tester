//IF
//zadanie - limit prędkości to 80. Jeżeli limit prędkości jest przekroczony to policz o ile i napisz: "Przekroczyłeś prędkość o: " + result + "km/h.
// Mandat jest w drodze!", jeżeli nie jest napisz: "Szerokiej drogi!"
//
//Zadanie (if else) :
//jeśli wiek poniżej 0 lat napisz: Wrong age
//jeśli wiek poniżej 10 lat napisz: Kid
//jeśli wiek między 10-17 napisz: Teenager
//jeśli wiek powyżej 18 napisz: Adult

import java.util.Scanner;
public class Demo {
    public static void main(String[] args) {

        Scanner myObj = new Scanner(System.in);
        System.out.println("Wprowadź prędkość:"); // Używamy nextInt(), aby pobrać liczbę całkowitą
        int speed = myObj.nextInt();

        int speedLimit = 80;
        if (speed > speedLimit) {
            giveFine(speed, speedLimit);
        } else {
            System.out.println("Szerokiej drogi!");
        }
    }

    private static void giveFine(int speed, int speedLimit) {
        int result = speed - speedLimit;
        System.out.println("Przekroczyłeś prędkość o: " + result + "km/h. Mandat jest w drodze!");
    }
}