package assignment24_streams;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Stream;

class Transaction {
    public Integer transationId;
    public LocalDateTime time;
    public String type;
    public String remarks;
    public Double amount;

    public Transaction(Integer transationId, LocalDateTime time, String type, String remarks, Double amount) {
        this.transationId = transationId;
        this.time = time;
        this.type = type;
        this.remarks = remarks;
        this.amount = amount;
    }
}


class TransactionProcessingUsingStreams {

    public static void main(String[] args) {
        List<Transaction> transactionList = Arrays.asList(
                new Transaction(1001134, LocalDateTime.of(2017, 4, 3, 11, 23, 31), "DR", "Paid phone bill", 533.0),
                new Transaction(1001453, LocalDateTime.of(2017, 3, 12, 16, 32, 42), "DR", "Paid internet bill", 800.0),
                new Transaction(1001271, LocalDateTime.of(2017, 3, 8, 19, 37, 38), "CR", "From bank account", 12000.0),
                new Transaction(1001014, LocalDateTime.of(2017, 4, 22, 9, 49, 19), "DR", "Paid electricity bill", 672.0),
                new Transaction(1001521, LocalDateTime.of(2017, 3, 17, 12, 17, 42), "CR", "From Jim", 15000.0),
                new Transaction(1001343, LocalDateTime.of(2017, 4, 15, 14, 13, 2), "DR", "To bank account", 1500.0)
        );

        transactionsAbove10k(transactionList);
    }

    public static void transactionsAbove10k(List<Transaction> transactionList) {
        System.out.println("Transactions above 10000:");

        //You can change the arguments of the stream operations here, and see how the results yield!
        transactionList.stream().filter(t -> {System.out.println("Filtering: " + t.transationId); return t.amount > 10000;})
                .map(t -> {System.out.println("Mapping: " + t.transationId); return t.transationId;})
                .sorted((x,y)->{System.out.println("Sorting"); return x-y;})


                .forEach(id -> System.out.println(id));
    }
}
class StreamsAreNonReUsable{
    public static void main(String[] args) {

            Stream<String> langNames1 = Stream.of("Java","Python","C++","C","C#","Dot Net");

            //Stream Operation #1
                langNames1.filter(name -> name.charAt(0)=='C')
                    .sorted()
                          .forEach(name -> System.out.println(name)); //Line1
//            Stream Operation #2
             		langNames1.map(name -> name.toLowerCase())
             		          .forEach(name-> System.out.println(name));

                //Comment Scenario 1 and Uncomment Scenario 2!
            // 		/**
            // 		 * Scenario #2
            // 		 */
            Stream<String> langNames2 = Stream.of("Java","Python","C++","C","C#","Dot Net");

            //Stream Operation #1
                langNames2.filter(name -> name.charAt(0)=='C')
                    .sorted();                                   //Line2

            //Stream Operation #2
            langNames2.map(name -> name.toLowerCase())
            .forEach(name-> System.out.println(name));

    }
}
class Research {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(3);
        list.add(6);
        list.add(9);

        list.stream().map(number -> number * 3).forEach(System.out::println);
    }
}