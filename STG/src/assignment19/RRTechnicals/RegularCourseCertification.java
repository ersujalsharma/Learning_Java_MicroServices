package assignment19.RRTechnicals;

public class RegularCourseCertification extends RRTechnicalCertification{
    private int courseDuration;

    public RegularCourseCertification(String studentName, String courseName, int courseDuration,int admissionTestMarks) {
        super(studentName, courseName, admissionTestMarks);
        generateRegistrationId();
        this.courseDuration = courseDuration;
    }

    public int getCourseDuration() {
        return courseDuration;
    }

    public void setCourseDuration(int courseDuration) {
        this.courseDuration = courseDuration;
    }
    public void generateRegistrationId(){
        super.generateRegistrationId();
    }
    public double calculateFee(){
        double val = REGULAR_COURSE_FEE*getCourseDuration();
        if(getAdmissionTestMarks()>=90){
            val = val*(0.90);
        }
        else if(getAdmissionTestMarks()>=75){
            val = val*(0.95);
        }
        return val;
    }
    public void displayDetails(){
        System.out.println("Regular Course Registration Details");
        System.out.println("************************************");
        System.out.println("Student Name: "+getStudentName());
        System.out.println("Course Name: "+getCourseName());
        System.out.println("Registration ID: "+getRegistrationId());
        System.out.println("Admission Test Marks: "+getAdmissionTestMarks());
        System.out.println("Course Duration: "+getCourseDuration()+" Months");
        System.out.println("Course Fee: "+calculateFee());
    }
}
