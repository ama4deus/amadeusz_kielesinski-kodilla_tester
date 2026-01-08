//Zadanie: stwórz pętlę while, która zapisze liczb od 1-10

public class Demo {

    public static void main(String[] args) {
        int sum = 0;

        for (int i = 1; i <= 10; i++) {
            sum = sum + i;
            System.out.println(sum);
        }
    }
}