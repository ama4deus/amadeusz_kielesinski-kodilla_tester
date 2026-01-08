class Profile {
    String name;
    double age;
    double height;

    public Profile(String name, double age, double height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }

    public void checkStatus() {

        if (name != null) {//Jeśli imię nie jest puste, przejdź do sprawdzania wieku i wzrostu
            if (age > 30 && height > 160) {
                System.out.println("User is older than 30 and taller than 160cm");
            } else {
                System.out.println("User is 30 (or younger) or 160cm (or shorter)");
            }
        }

    }
}
