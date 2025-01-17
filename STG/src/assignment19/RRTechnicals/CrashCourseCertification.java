package assignment19.RRTechnicals;

public class CrashCourseCertification extends RRTechnicalCertification{
    public CrashCourseCertification(String studentName, String courseName, int admissionTestMarks) {
        super(studentName, courseName, admissionTestMarks);
        generateRegistrationId();
    }

    @Override
    public int getRegistrationId() {
        return super.getRegistrationId();
    }

    @Override
    public double calculateFee() {
        double val = CRASH_COURSE_FEE;
        if(getAdmissionTestMarks()>=90){
            val = val*(0.90);
        }
        else if(getAdmissionTestMarks()>=75){
            val = val*(0.95);
        }
        return val*(1+0.1236);
    }
    public void displayDetails(){
        System.out.println("Crash Course Registration Details");
        System.out.println("************************************");
        System.out.println("Student Name: "+getStudentName());
        System.out.println("Course Name: "+getCourseName());
        System.out.println("Registration ID: "+getRegistrationId());
        System.out.println("Admission Test Marks: "+getAdmissionTestMarks());
        System.out.println("Course Duration: "+2+" Months");
        System.out.println("Course Fee: "+calculateFee());
    }
}
