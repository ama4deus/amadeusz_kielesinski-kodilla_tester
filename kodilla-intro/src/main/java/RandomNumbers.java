import java.util.Random; //import klasy Random

public class RandomNumbers {

    private int sumOfNumbers = 0; //Zmienna składowa przechowująca sumę wszystkich wylosowanych liczb
    private int minValue = 31; //zmienna składowa przechowująca najmniejszą wylosowaną liczbę, pierwsza  wylosowana liczba będzie mniejsza niż 30
    private int maxValue = 0; /*Zmienna składowa przechowująca największą wylosowaną liczbę. Inicjalizowana wartością 0,
    pierwsza wylosowana liczba będzie większa niż 0, bądź równa*/

    private final Random randomGenerator = new Random(); // instancja klasy random, final - referencja ustwiona raz, nie można jej zmienić

    public void generateUntilSumExceeded() { // void ponieważ metoda ma modyfikować stan wewnętrzny klasy

        while (sumOfNumbers <= 5000) {
            int currentNumber = randomGenerator.nextInt(31); //zapewnia zakres 0-30 włącznie
            /*Deklarowana jest nowa lokalna zmienna currentNumber,
            której przypisywana jest losowa liczba całkowita z zakresu od 0 do 30 włącznie */
            sumOfNumbers = sumOfNumbers + currentNumber; //dodawanie do Sumy
            if (currentNumber < minValue) { //Sprawdzenie Minimum
                minValue = currentNumber; //ustawia wylosowaną liczbę jako nową minimalną wartość
            }
            if (currentNumber > maxValue) { //sprawdzenie Maksimum
                maxValue = currentNumber; //Aktualizacja Maksimum
            }
        }
    }

    public int getSumOfNumbers() {
        return sumOfNumbers; //zwrócenie sumy
    }

    public int getMinValue() {
        return minValue; //zwrócenie minimum
    }

    public int getMaxValue() {
        return maxValue; // zwrócenie maksimum
    }

}





