package assignment8.varArgs;

public class Tester {
    public static int sum(int... numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }
    public static void main(String[] args) {
        int val1 = sum(1,2);
        int val2 = sum(1,2,3);
        int val3 = sum(1,2,3,4);
        int val4 = sum(1,2,3,4,5);
        int val5 = sum(1,2,3,4,5,6);
        System.out.println("Sum of 1, 2"+" = "+val1);
        System.out.println("Sum of 1, 2, 3"+" = "+val2);
        System.out.println("Sum of 1, 2, 3, 4"+" = "+val3);
        System.out.println("Sum of 1, 2, 3, 4, 5"+" = "+val4);
        System.out.println("Sum of 1, 2, 3, 4, 5, 6"+" = "+val5);
    }
}
