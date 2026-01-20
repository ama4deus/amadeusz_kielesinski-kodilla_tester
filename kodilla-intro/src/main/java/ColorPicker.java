import java.util.Scanner;

public class ColorPicker {

    public static char pobierzLitere() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wpisz pierwszą literę koloru: ");
        char litera = scanner.next().charAt(0);
        return litera;
    }

    public static void main(String[] args) {
       char wybranaLitera = pobierzLitere();
        switch (wybranaLitera) {

            case'C':
            case 'c':
                System.out.println("Czerwony");
                break;

            case'N':
            case 'n':
                System.out.println("Niebieski");
                break;

            case 'Z':
            case 'z':
                System.out.println("Zielony");
                break;

            default:
                System.out.println("Nie rozpoznaję tej litery.");
                break;
        }
    }
}
