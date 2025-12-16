public class User {
    private String name; //tutaj deklarujemy atrybut klasy
    private int age;

    public User(String name, int age) { //konstruktor
        this.name = name; //przypisanie wartości
        this.age = age;
    }

    public String getName() { //metoda dostępu getter, publiczna metoda dostępu
        return name;
    }

    public int getAge() {
        return age;
    }

    public static void main(String[] args) { //sekwencja tworzenia instancji (obiektów) klasy User
        User anna = new User("Anna", 20);
        User betty = new User("Betty", 33);
        User carl = new User("Carl", 58);
        User david = new User("David", 13);
        User eva = new User("Eva", 18);
        User frankie = new User("Frankie", 45);

        User[] users = {anna, betty, carl, david, eva, frankie}; //głównym celem stworzenia tablicy users jest grupowanie i przetwarzanie wielu obiektów w jednej operacji

        int sumOfAge = 0; /*Ta linijka deklaruje i inicjalizuje zmienną lokalną sumOfAge wartością 0,
        która służy jako akumulator do zliczania całkowitej sumy wieku wszystkich użytkowników w pętli */
        for (int i = 0; i < users.length; i++) { //pętla "for" służąca do obliczania sumy wieku wszystkich użytkowników w tablicy.
            sumOfAge = sumOfAge + users[i].getAge(); //wartość sumy zostaje zwiększona o wiek użytkownika z bieżącego elementu tablicy  ???? (nie do końca rozumiem)
        }

        double averageAge = (double) sumOfAge / users.length;
        //(double) sumOfAge - oprator rzutowania, tymczasowo traktuje wartość sumOfAge (która jest int) jako liczbę zmiennoprzecinkową (double)


        System.out.println("Average age: " + averageAge);
        System.out.println("Users younger than average:");

        for (User person : users) { // dla każdego obiektu User nazwanego 'person' w tablicy users
            if (person.getAge() < averageAge) { // Sprawdzamy wiek 'person'
                System.out.println("- " + person.getName() + " (age: " + person.getAge() + ")"); // Wyświetlamy dane 'person'
            }
        }
    }
}
