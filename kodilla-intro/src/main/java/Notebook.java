class Notebook { //KONSTRUKTOR
    int weight;
    int price;
    int year;

    public Notebook(int weight, int price, int year) {
        this.weight = weight;
        this.price = price;
        this.year = year;
    }

    public void checkPrice() {
        if (this.price < 600) {
            System.out.println("This notebook is very cheap.");
        } else if (this.price >= 600 && this.price <= 1000) {
            System.out.println("The price is good.");
        } else if (this.price > 1000) {
            System.out.println("This notebook is expensive.");
        }
    }

    public void checkWeight() {
        if (this.weight < 1000) {
            System.out.println("The weight is light.");
        } else if (this.weight >= 1000 && this.weight <= 1500) {
            System.out.println("The weight is not heavy.");
        } else if (this.weight > 1500) {
            System.out.println("The weight is heavy.");
        }
    }

    public void worthBuying() {
        if (this.year >= 2023 && this.price <= 1000) {
            System.out.println("Buy it!");
        } else if (this.year >= 2020 && this.year < 2023 && this.price < 1000) {
            System.out.println("Consider it.");
        } else {
            System.out.println("Don't buy it...");
        }
    }

}


