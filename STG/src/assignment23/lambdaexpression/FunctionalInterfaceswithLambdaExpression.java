package assignment23.lambdaexpression;

import java.util.function.*;

public class FunctionalInterfaceswithLambdaExpression {
    public static void main(String[] args) {
        Function<Integer,Integer> addition = (value) -> value + 10;
        System.out.println(addition.apply(10));
        Predicate<Integer> isEven = (value) -> value % 2 == 0;
        System.out.println(isEven.test(10));
        BiPredicate<Integer,Integer> isGreater = (value1,value2) -> value1 > value2;
        System.out.println(isGreater.test(10,20));
        Consumer<Integer> print = (value) -> System.out.println(value);
        print.accept(10);
        Supplier<Integer> random = () -> (int)(Math.random()*100);
        System.out.println(random.get());
        BiFunction<Integer,Integer,Integer> multiply = (value1,value2) -> value1 * value2;
        System.out.println(multiply.apply(10,20));
    }
}
