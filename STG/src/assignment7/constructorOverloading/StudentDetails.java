package assignment7.constructorOverloading;

public class StudentDetails {
    private String name;
    private Integer rollNumber;


    //constructor used when no name is specified
    StudentDetails(){
        name = "N.A.";
        rollNumber = -1;

    }

    //constructor used when name and rollNumber is specified
    StudentDetails(String username,Integer rollNo){
        name = username;
        rollNumber = rollNo;
    }

    //constructor used when name is specified
    StudentDetails(String studentName){
        // this() will invoke the default constructor StudentDetails()
        // which will initialize name to N.A. and rollNumber to -1
        this();
        name=studentName;
        // The above statement will re-initialize name from N.A. to studentName

    }

    //constructor used when rollNumber is specified
    StudentDetails(Integer rollno){
        this();
        // this() will invoke the default constructor StudentDetails()
        // which will initialize name to N.A. and rollNumber to -1
        rollNumber=rollno;
        // The above statement will re-initialize rollNumber from -1 to rollno
    }

    public void displayStudentDetails(){
        System.out.println("Student Details :- ");
        System.out.println("Name :- "+name);
        System.out.println("Roll Number :- "+rollNumber);
    }


    public static void main(String[] args) {

        StudentDetails student1 = new StudentDetails();
        student1.displayStudentDetails();
        System.out.println();

        StudentDetails student2 = new StudentDetails("Joe",42);
        student2.displayStudentDetails();
        System.out.println();

        StudentDetails student3 = new StudentDetails("Tommy");
        student3.displayStudentDetails();
        System.out.println();

        StudentDetails student4  = new StudentDetails(70);
        student4.displayStudentDetails();
        System.out.println();

    }
}
