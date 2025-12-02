public class SimpleArray {
    public static void main(String[] args) {
        String[] names = new String[5];
        names[0] = "Marta";
        names[1] = "Paulina";
        names[2] = "Emilka";
        names[3] = "Kasia";
        names[4] = "Justyna";
String name = names[3];
        System.out.println(name);
        int numberOfElements = names.length;
        System.out.println("My table has" + " " + numberOfElements + " " + "elements.");
    }
}
