package assignment11.inheritance_excercise1;

public class Excercise1 {
    public static void main(String[] args) {
        PermanentEmployee emp1 = new PermanentEmployee();
        emp1.setEmpId(101);
        emp1.setName("Anil");
        emp1.setBasicPay(10000);
        emp1.setHra(1500);
        emp1.setExperience(3);
        double val = emp1.calculateSalary();
        System.out.println("Salary of Permanent Employee - > "+emp1.getName()+" is "+val);
        ContractEmployee emp2 = new ContractEmployee();
        emp2.setName("Ankit");
        emp2.setEmpId(102);
        emp2.setWage(500);
        emp2.setHours(10);
        double val2 = emp2.calculateSalary();
        System.out.println("Salary of Contract Employee - > "+emp2.getName()+" is "+val2);
    }
}
class Employee{
    private int empId;
    private String name;
    private double salary;
    public int getEmpId() {
        return empId;
    }
    public void setEmpId(int empId) {
        this.empId = empId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }

}

class PermanentEmployee extends Employee{
    private double basicPay;
    private double hra;
    private int experience;
    public double getBasicPay() {
        return basicPay;
    }
    public void setBasicPay(double basicPay) {
        this.basicPay = basicPay;
    }
    public double getHra() {
        return hra;
    }
    public void setHra(double hra) {
        this.hra = hra;
    }
    public int getExperience() {
        return experience;
    }
    public void setExperience(int experience) {
        this.experience = experience;
    }
	/*
		code here
	*/
    public double calculateSalary(){
        double salary = basicPay + hra;
        int variablePercentage = 0;
        if(getExperience()<3){
            variablePercentage = 0;
        }
        else if(getExperience()<5){
            variablePercentage = 5;
        }
        else if(getExperience()<10){
            variablePercentage = 7;
        }
        else{
            variablePercentage = 12;
        }
        return  salary + (basicPay * variablePercentage / 100);
    }
}

class ContractEmployee extends Employee{
    private double wage;
    private int hours;
    public double getWage() {
        return wage;
    }
    public void setWage(double wage) {
        this.wage = wage;
    }
    public int getHours() {
        return hours;
    }
    public void setHours(int hours) {
        this.hours = hours;
    }
	/*
		code here
	*/
    public double calculateSalary(){
        return wage * hours;
    }
}