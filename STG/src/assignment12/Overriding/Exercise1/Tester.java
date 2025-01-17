package assignment12.Overriding.Exercise1;

public class Tester {
    public static void main(String[] args) {
        Traveller traveller = new Traveller();
        traveller.setName("Roger");
        traveller.setId("AQW1344321");
        traveller.setFare(2000);
        traveller.displayDetails();
        SeniorTraveller senior = new SeniorTraveller();
        senior.setId("PJAMG7755TY");
        senior.setName("Joey");
        senior.setAge(70);
        senior.setFare(2000);
        senior.displayDetails();
    }
}
class Traveller {
    private String name;
    private String id;
    private double fare;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getFare() {
        return fare;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }

    // code as per class diagram
    public double calculateFare() {
        // code here
        return this.fare + (this.fare * 11.36 / 100);
    }

    // displayDetails
    public void displayDetails() {
        // code here
        System.out.println("Name : " + this.name);
        System.out.println("ID : " + this.id);
        System.out.println("Fare : " + this.fare);
        System.out.println("Total Fare : " + calculateFare());
    }
}
class SeniorTraveller extends Traveller{
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // code as per class diagram
    @Override
    public double calculateFare(){
        double calculatedFare = super.calculateFare();
        if(getAge()>65){
            return calculatedFare - (calculatedFare*15/100);
        }
        else if(getAge()>=50)
            return calculatedFare - (calculatedFare*10/100);
        return -1;
    }
    // displayDetails
    @Override
    public void displayDetails(){
        // code here
        super.displayDetails();
        System.out.println("Age : "+this.age);
    }
}