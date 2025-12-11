public class FirstClass {
    public static void main(String[] args) {

        Notebook notebook = new Notebook(600, 1000, 2025);
        System.out.println("Notebook - " + "weight: " + notebook.weight + ", " + "price: " + notebook.price + ", " + "year: " + notebook.year);
        notebook.checkPrice();
        notebook.checkWeight();
        notebook.worthBuying();

        System.out.println();

        Notebook heavyNotebook = new Notebook(2000, 1500, 2020);
        System.out.println("Heavy Notebook - " + "weight: " + heavyNotebook.weight + ", " + "price: " + heavyNotebook.price + ", " + "year: " + heavyNotebook.year);
        heavyNotebook.checkPrice();
        heavyNotebook.checkWeight();
        heavyNotebook.worthBuying();

        System.out.println();

        Notebook oldNotebook = new Notebook(1600, 500, 2019);
        System.out.println("Old Notebook - " + "weight: " + oldNotebook.weight + ", " + "price: " + oldNotebook.price + ", " + "year: " + oldNotebook.year);
        oldNotebook.checkPrice();
        oldNotebook.checkWeight();
        oldNotebook.worthBuying();

        System.out.println();

        Notebook goodNotebook = new Notebook(1000, 600, 2020);
        System.out.println("Good Notebook - " + "weight: " + goodNotebook.weight + ", " + "price: " + goodNotebook.price + ", " + "year: " + goodNotebook.year);
        goodNotebook.checkWeight();
        goodNotebook.checkPrice();
        goodNotebook.worthBuying();

        System.out.println();

        Notebook notGoodNotebook = new Notebook(1100, 1200, 2019);
        System.out.println("Not Good Notebook - " + "weight: " + notGoodNotebook.weight + ", " + "price: " + notGoodNotebook.price + ", " + "year: " + notGoodNotebook.year);
        notGoodNotebook.checkWeight();
        notGoodNotebook.checkPrice();
        notGoodNotebook.worthBuying();

    }
}