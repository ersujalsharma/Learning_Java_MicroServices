package assignment17.SujalUniversity;

public class CourseRegistration {
    private String studentName;
    private int registrationId;
    private float qualifyingMarks;
    private double courseFee;
    private int courseId;
    private boolean hostelRequired;

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(int registrationId) {
        this.registrationId = registrationId;
    }

    public float getQualifyingMarks() {
        return qualifyingMarks;
    }

    public void setQualifyingMarks(float qualifyingMarks) {
        this.qualifyingMarks = qualifyingMarks;
    }

    public double getCourseFee() {
        return courseFee;
    }

    public void setCourseFee(double courseFee) {
        this.courseFee = courseFee;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public boolean isHostelRequired() {
        return hostelRequired;
    }

    public void setHostelRequired(boolean hostelRequired) {
        this.hostelRequired = hostelRequired;
    }
    public boolean validateMarks(){
        if(qualifyingMarks >= 65 && qualifyingMarks<=100){
            return true;
        }
        return false;
    }
    public boolean validateCourseId(){
        if(courseId >= 1001 && courseId <= 1005){
            return true;
        }
        return false;
    }
    public void calculateCourseFee(){
        double basicFee = 0;
        if(getCourseId()==1001){
            basicFee = 55000;
        }
        else if(getCourseId()==1002){
            basicFee = 35675;
        }
        else if(getCourseId()==1003){
            basicFee = 28300;
        }
        else if(getCourseId()==1004){
            basicFee = 22350;
        }
        else{
            basicFee = 115000;
        }

        if(getQualifyingMarks()>=65 && getQualifyingMarks()<=69){
            setCourseFee(basicFee*0.95);
        }
        else if(getQualifyingMarks()>=70 && getQualifyingMarks()<=84){
            setCourseFee(basicFee*0.90);
        }
        else{
            setCourseFee(basicFee*0.85);
        }
    }
    // print
    public void printDetails(){
        if(validateCourseId() && validateMarks()){
            calculateCourseFee();
        }
        else{
            System.out.println("Invalid Data");
            return;
        }
        System.out.println("Student Name: " + getStudentName());
        System.out.println("Registration ID: " + getRegistrationId());
        System.out.println("Qualifying Marks: " + getQualifyingMarks());
        System.out.println("Course ID: " + getCourseId());
        System.out.println("Hostel Required: " + isHostelRequired());
        System.out.println("Validation: " + validateMarks());
        System.out.println("Course Fee: " + getCourseFee());
        System.out.println("Booked Successfully - Course Fee: " + getCourseFee());
    }
}
