package assignment13_ObjectsExercise;

import java.util.Objects;

class Customer {
    private int customerId;
    private String name;
    private String phone;

    public Customer(int id, String name, String phone) {
        //code here
        this.customerId = id;
        this.name = name;
        this.phone = phone;
    }

    public String toString() {
        //Output should be in given format
        return "Customer-"+this.name+" with ID-"+this.customerId;
    }
    // code equals and hashCode here
    public Boolean equals(Customer o){
        if(this.hashCode() == o.hashCode()){
            return true;
        }
        return false;
    }
    public int hashCode(){
        return Objects.hash(customerId,name,phone);
    }
}

public class Exercise {
    public static void main(String[] args) {
        Customer c1 = new Customer(105, "Max", "8574637281");
        Customer c2 = new Customer(109, "Nick", "9453281756");
        Customer c3 = new Customer(109, "Nick", "9453281756");
        System.out.println(c1);
        System.out.println(c1.equals(c2));
        System.out.println(c3.equals(c2));
    }
}
