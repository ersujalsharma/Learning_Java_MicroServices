package assignment6.exercise;
class Car{
    private String color;
    private static int numberOfCars = 0;    //static variable

    public Car(String color) {
        // code here
        this.color = color;
        numberOfCars++;
    }

    public String getColor() {       //static method
        return this.color;
    }

    public static int getNumberOfCars() {
        return numberOfCars;
    }

    public void displayColor() {
        System.out.println("Color of the car : "+this.color);
    }
}
public class Problem_1 {
    public static void displayCar() {
        System.out.println("Displaying Car details");
    }

    public static void main(String[] args) {
        Car c1 = new Car("Red");
        Car c2 = new Car("Green");
        Car c3 = new Car("Blue");
		/*
			write code here to display the color
		*/
        displayCar();
        System.out.println("Number of cars created : "+Car.getNumberOfCars());
        System.out.println("Color of the cars : ");
        c1.displayColor();
        c2.displayColor();
        c3.displayColor();
    }
}
