package assignment19.RRTechnicals;

public class Tester {
    public static void main(String[] args) {
        RegularCourseCertification regularCourseCertification = new RegularCourseCertification("Rakesh", "J2EE", 5,85);
        regularCourseCertification.displayDetails();
        CrashCourseCertification crashCourseCertification = new CrashCourseCertification("Roshan", "Angular", 71);
        crashCourseCertification.displayDetails();
    }
}
