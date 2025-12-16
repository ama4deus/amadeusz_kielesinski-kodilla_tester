public class Grades {
    private int[] grades;
    private int size;

    public Grades() {
        this.grades = new int[10];
        this.size = 0;
    }

    public void add(int value) {
        if (this.size == 10) {
            return;
        }
        this.grades[this.size] = value;
        this.size++;
    }

    public int getLastGrade() {
    /* Tutaj miałem problem, żeby wpaść na rozwiązanie, użyłem AI,
    "public"-publiczna metoda dostępna dla innych klas,
    "int" typ zwracany to jedna liczba całkowita,
    "getLastGrade" - unikalna nazwa,
    "()"-informuje, że "getLastGrade" to metoda, puste () informują, że ta metoda nie wymaga żadnych dodatkowych danych */
        if (this.size == 0) {
            // sprawdza, czy aktualna liczba elementów w kolekcji ocen (this.size) jest równa zero
            return -1;
            //instrukcja ta kończy działanie metody i zwraca wartość -1 jako jej wynik
        }
        return this.grades[this.size - 1];
        /* Zwróć wartość, która znajduje się w tablicy grades pod indeksem równym aktualnemu rozmiarowi kolekcji (this.size)
         pomniejszonemu o jeden, ponieważ indeksowanie w Java zaczyna się od 0 */
    }

    public double getAverage() {
        if (this.size == 0) {
            return 0.0; // Zwracamy 0, jeśli nie ma ocen, aby uniknąć dzielenia przez zero
        }
        int sum = 0; // Zaczynamy od 0
        for (int i = 0; i < this.size; i++) {
        /* i=0 ponieważ w indeksie pierwsza ocena jest na miejscu 0
        * i < this.size ponieważ komputer sprawdza, czy bieżąca wartość jest mniejsza niż this.size (które przechowuje aktualną liczbę ocen)
        i++ zwiększa wartość licznika i o 1 */
            sum += this.grades[i];
            /*Weź ocenę o obecnym indeksie (i) z naszej listy ocen (this.grades) i dodaj ją do naszej rosnącej sumy (sum).
             Następnie zapisz tę nową, powiększoną sumę z powrotem w zmiennej sum."
            "+=" oznacza dodaj i przypisz */
        }
        return (double) sum / this.size;
    }
}

