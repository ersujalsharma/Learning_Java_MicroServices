package assignment24_streams;

import java.util.*;

public class Excercise_2 {
    public static void main(String[] args) {
        List<String> names=new ArrayList<String>();
        names.add("Jack");
        names.add("John");
        names.add("Jill");
        names.add("Jim");
        names.add("Garry");
        names.add("Frank");
        names.stream().filter((name)->name.startsWith("J") && name.length()==4).forEach(System.out::println);
    }
}
