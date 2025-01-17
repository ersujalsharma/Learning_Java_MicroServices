package assignment19.RRTechnicals;

public class RRTechnicalCertification implements Certification{
    private String studentName;
    private String courseName;
    private int registrationId;
    private int admissionTestMarks;
    public static int counter = 1000;

    public RRTechnicalCertification(String studentName, String courseName, int admissionTestMarks) {
        this.studentName = studentName;
        this.courseName = courseName;
        this.admissionTestMarks = admissionTestMarks;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(int registrationId) {
        this.registrationId = registrationId;
    }

    public int getAdmissionTestMarks() {
        return admissionTestMarks;
    }

    public void setAdmissionTestMarks(int admissionTestMarks) {
        this.admissionTestMarks = admissionTestMarks;
    }
    public void generateRegistrationId(){
        counter++;
        if(this instanceof RegularCourseCertification){
            if(counter%2==0){
                counter++;
            }
        }
        else{
            if(counter%2==1){
                counter++;
            }
        }
        this.registrationId = counter;
    }
    @Override
    public double calculateFee() {
        return 0;
    }
}
