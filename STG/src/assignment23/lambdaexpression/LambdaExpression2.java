package assignment23.lambdaexpression;
@FunctionalInterface
interface Operation{
    public double operation(double num1, double num2);
}
public class LambdaExpression2 {
    public static double doOperation(double num1,double num2,Operation operation){
        return operation.operation(num1, num2);
    }
//    public static double addCriteria(double firstNum, double secondNum,Operation operation) {
//        return switch(operation){
//            case add -> firstNum + secondNum;
//            case subtract -> firstNum - secondNum;
//            case multiply -> firstNum * secondNum;
//            case divide -> firstNum / secondNum;
//            case default -> 0;
//        };
//    }
    public static void main(String[] args) {
        Operation add = (double num1, double num2) -> num1 + num2;
        Operation add2 = (num1, num2) -> num1 + num2;
        Operation subtract = (double num1, double num2) -> num1 - num2;
        Operation subtract2 = (num1, num2) -> num1 - num2;
        Operation multiply = (double num1, double num2) -> num1 * num2;
        Operation multiply2 = (num1, num2) -> num1 * num2;
        Operation divide = (double num1, double num2) -> num1 / num2;
        Operation divide2 = (num1, num2) -> num1 / num2;
        double val = doOperation(12, 4, add);
        double val2 = doOperation(12, 4, subtract);
        double val3 = doOperation(12, 4, multiply);
        double val4 = doOperation(12, 4, divide);
        System.out.println("Result is: " + val);
        System.out.println("Result is: " + val2);
        System.out.println("Result is: " + val3);
        System.out.println("Result is: " + val4);
//        System.out.println(addCriteria(12, 4, Operation.add));
        System.out.println(doOperation(12, 4, (num1, num2) -> num1 + num2));
    }
}
