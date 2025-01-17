package assignment17.SujalUniversity;

public class Tester {
    public static void main(String[] args) {
        CourseRegistration courseRegistration = new CourseRegistration();
        courseRegistration.setStudentName("Peter");
        courseRegistration.setRegistrationId(5001);
        courseRegistration.setQualifyingMarks(78);
        courseRegistration.setCourseId(1005);
        courseRegistration.setHostelRequired(true);
        // print details
        courseRegistration.printDetails();
    }
}
