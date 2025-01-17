package assignment16_interfaceExercise;

interface Student{
    public int TOTAL_MAXIMUM_MARKS = 400;
    public void calcPercentage();

}

// code here
// class Intern and Trainee
class Intern implements Student{
    private int marksSecured;
    private int projectMarks;

    public Intern(int marksSecured, int projectMarks) {
        this.marksSecured = marksSecured;
        this.projectMarks = projectMarks;
    }

    @Override
    public void calcPercentage() {
        double val =  ((marksSecured + projectMarks) / (double)TOTAL_MAXIMUM_MARKS)*100;
        System.out.println(val);
    }
}
class Trainee implements Student{
    private int marksSecured;

    public Trainee(int marksSecured) {
        this.marksSecured = marksSecured;
    }

    @Override
    public void calcPercentage() {
        double val =  ((marksSecured) / (double)TOTAL_MAXIMUM_MARKS)*100;
        System.out.println(val);
    }
}
public class Tester{
    public static void main (String[] args) {
        /* code */
        Intern intern = new Intern(283,77);
        intern.calcPercentage();
        Trainee trainee = new Trainee(370);
        trainee.calcPercentage();
    }
}
