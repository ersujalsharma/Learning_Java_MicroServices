public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        System.out.println(sum(5.0,6.0));
    }
    // create generic sum method here
    public static <T extends Number> Number sum(T a, T b) {
        return a.doubleValue()+b.doubleValue();
    }
}