public class Book {
    private String author;
    private String title;

    public Book(String author, String title) {
        this.author = author;
        this.title = title;
    }

    public static Book of(String author, String title) {
        return new Book(author, title);
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public static void main(String[] args) {
        // 1. Tworzymy obiekt - nie piszemy "new Book", tylko używamy "of"
        Book mojaKsiazka = Book.of("Stephen King", "Lśnienie");

        System.out.println("Moja książka to: " + mojaKsiazka.getTitle());
        System.out.println("Autorem jest: " + mojaKsiazka.getAuthor());
    }

}


