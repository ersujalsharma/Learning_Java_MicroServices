package assignment16_interfaceExercise;

public class SealedInterfacePractice {
}
final class Help1 implements Student2{
    private int marksSecured;
    private int projectMarks;

    public Help1(int marksSecured, int projectMarks) {
        this.marksSecured = marksSecured;
        this.projectMarks = projectMarks;
    }

    @Override
    public void calcPercentage() {
        double val =  ((marksSecured + projectMarks) / (double)TOTAL_MAXIMUM_MARKS)*100;
        System.out.println(val);
    }
}
non-sealed class Help2 implements Student2{
    private int marksSecured;

    public Help2(int marksSecured) {
        this.marksSecured = marksSecured;
    }

    @Override
    public void calcPercentage() {
        double val =  ((marksSecured) / (double)TOTAL_MAXIMUM_MARKS)*100;
        System.out.println(val);
    }
}
sealed interface Student2 permits Help1, Help2{
    public int TOTAL_MAXIMUM_MARKS = 400;
    public void calcPercentage();
}
