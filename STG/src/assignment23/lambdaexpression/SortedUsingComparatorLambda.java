package assignment23.lambdaexpression;

import java.util.*;

public class SortedUsingComparatorLambda {
    public static void main(String[] args) {
        List<String> nameList = Arrays.asList("Rachael","Ross","Monica",
                "Chandler","Joey","Phoebe");

        //Cloning the the nameList for the demo
        List<String> clonedNameList1 = new ArrayList<String>(nameList);
        List<String> clonedNameList2 = new ArrayList<String>(nameList);
        List<String> clonedNameList3 = new ArrayList<String>(nameList);


        /**
         *      Sorting Using Collections.sort():
         **/

        System.out.println("Sorting done by Collections.sort(): ");
        Collections.sort(nameList);
        System.out.println(nameList);

        System.out.println();

        /**
         *      Sorting Using list.sort() #1 : Sorting using Natural Order
         **/

        //Lambda Expression for sorting the list in Natural Order
        Comparator<String> criteria = (str1, str2) -> str1.compareTo(str2);

        System.out.println("Sorting done by list.sort() in Natural Order: ");
        clonedNameList1.sort(criteria);
        System.out.println(clonedNameList1);

        System.out.println();

        /**
         *      Sorting Using list.sort() #2 : Sorting on the basis of Length of Elements
         **/

        //Lambda Expression for sorting the list on the basis of Length:
        System.out.println("Sorting done by list.sort() on the basis of Length: ");
        clonedNameList2.sort((str1, str2) -> str1.length() - str2.length());
        System.out.println(clonedNameList2);

        System.out.println();

        /**
         *     Sorting Using list.sort() #3 : Sorting on the basis of First Character of Elements
         **/

        //Lambda Expression for sorting the list on the basis of First Character
        System.out.println("Sorting done by list.sort() on the basis of First Character: ");
        clonedNameList3.sort((str1, str2) -> str1.charAt(0) - str2.charAt(0));
        System.out.println(clonedNameList3);
    }
}
