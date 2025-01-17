package assignment15.abstractMethods.excercise;

import java.util.Arrays;

abstract class Student{
    private String name;
    private int[] test;
    private String result;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int[] getTest() {
        return test;
    }
    public void setTest(int[] test) {
        this.test = test;
    }
    public String getResult() {
        return result;
    }
    public void setResult(String result) {
        this.result = result;
    }

    //code here
    public Student(String studentName) {
        this.name = studentName;
    }
    public abstract void generateResult();
    public void setScore(int testNumber,int testScore){
        test[testNumber] = testScore;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", test=" + Arrays.toString(test) +
                ", result='" + result + '\'' +
                '}';
    }
}

class UndergraduateStudent extends Student{
    public UndergraduateStudent(String studentName) {
        super(studentName);
    }
    //code here

    @Override
    public void generateResult() {
        int avg = 0;
        for(int i : getTest()){
            avg+=i;
        }
        avg/=getTest().length;
        if(avg>=60){
            setResult("Pass");
        }
        else{
            setResult("Fail");
        }
    }
}

class GraduateStudent extends Student{
    public GraduateStudent(String studentName) {
        super(studentName);
    }

    @Override
    public void generateResult() {
        int avg = 0;
        for(int i : getTest()){
            avg+=i;
        }
        avg/=getTest().length;
        if(avg>=70){
            setResult("Pass");
        }
        else{
            setResult("Fail");
        }
    }
    //code here
}

public class Tester{
    public static void main(String[] args) {
        //code here
        GraduateStudent graduateStudent = new GraduateStudent("Ajay");
        int arr[] = new int[4];
        graduateStudent.setTest(arr);
        graduateStudent.setScore(0,70);
        graduateStudent.setScore(1,69);
        graduateStudent.setScore(2,71);
        graduateStudent.setScore(3,55);
        graduateStudent.generateResult();
        System.out.println(graduateStudent);

        UndergraduateStudent undergraduateStudent = new UndergraduateStudent("Mehul");
        int arr2[] = new int[4];
        undergraduateStudent.setTest(arr);
        undergraduateStudent.setScore(0,70);
        undergraduateStudent.setScore(1,69);
        undergraduateStudent.setScore(2,71);
        undergraduateStudent.setScore(3,55);
        undergraduateStudent.generateResult();
        System.out.println(undergraduateStudent);
    }
}