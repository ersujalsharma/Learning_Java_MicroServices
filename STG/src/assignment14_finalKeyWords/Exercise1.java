package assignment14_finalKeyWords;

public class Exercise1 {
        final int test = 50;

        public static void main(String[] args)
        {
            final int testResult = 30;
            final int test; // Line 1

            Exercise1 t = new Exercise1();
            test = 20; // Line 2

            System.out.println(test);
            System.out.println(t.calculate(testResult));
        }

        int calculate(int a)
        {
            return a + 10;
        }
}
