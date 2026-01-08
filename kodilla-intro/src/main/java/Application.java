public class Application {
    public static void main(String[] args) {
        Profile adam = new Profile("Adam", 40, 178);
        System.out.println("name: " + adam.name + ", age: " + adam.age + ", height: " + adam.height);
        adam.checkStatus(); //operatorem wywołania

    }
}
