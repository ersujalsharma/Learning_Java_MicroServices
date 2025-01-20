package assignment23.lambdaexpression;

import java.util.List;

public class LambdaExpressionLearning {
    public static double doOperation(double num1, double num2, String operation) {
        switch (operation) {
            case "add":
                return addCriteria(num1, num2);
            case "subtract":
                return subCriteria(num1, num2);
            case "multiply":
                return mulCriteria(num1, num2);
            default:
                //Considering there are no wrong inputs, the default case is for operation=="divide"
                return divCriteria(num1, num2);
        }

    }


    //Method for Addition
    public static double addCriteria(double firstNum, double secondNum) {
        double result = firstNum + secondNum;
        return result;
    }

    //Method for Subtraction
    public static double subCriteria(double firstNum, double secondNum) {
        double result = firstNum - secondNum;
        return result;
    }

    //Method for Multiplication
    public static double mulCriteria(double firstNum, double secondNum) {
        double result = firstNum * secondNum;
        return result;
    }

    //Method for Division
    public static double divCriteria(double firstNum, double secondNum) {
        double result = firstNum / secondNum;
        return result;
    }


    public static void main(String[] args) {

        //Change the values and operations ("add","subtract","multiply" and "divide" only)
        System.out.println("Result is: " + doOperation(12, 4, "multiply"));
        System.out.println("Result is: " + doOperation(12, 4, "add"));
        List.of(1,2).forEach(System.out::println);
    }
}
