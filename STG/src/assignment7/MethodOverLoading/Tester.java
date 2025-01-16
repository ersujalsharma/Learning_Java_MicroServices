package assignment7.MethodOverLoading;

public class Tester {
    public static void main(String[] args) {

        Shape shape = new Shape();

        float circleArea = shape.calculateArea(1.7f);
        float rectangleArea = shape.calculateArea(2.5f, 3.4f);

        System.out.println("Area of circle: " + circleArea);
        System.out.println("Area of rectangle: " + rectangleArea);

        // Invoke the method to find the area of triangle
        // Display the area of triangle
        double triangleArea = shape.calculateArea(2, 3,4);
        System.out.println("Area of triangle: " + triangleArea);
    }
}

class Shape {

    // Method to find the area of circle
    public float calculateArea(float radius) {
        return 3.14f * radius * radius;
    }

    // Method to find the area of rectangle
    public float calculateArea(float length, float breadth) {
        return length * breadth;
    }

    // Code another overloaded method to find the area of triangle
    public double calculateArea(float a,float b,float c) {
        return Math.sqrt((a+b+c)*(b+c)*(a+c)*(a+b))/4;
    }
}