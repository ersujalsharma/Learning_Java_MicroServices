package assignment21.exceptionalHandling;

public class Tester {
    public static void main(String[] args) {
        Applicant applicant = new Applicant();
        applicant.setApplicantName("Jason");
        applicant.setPostAppied("Assistant");
        applicant.setApplicantAge(37);
        Validator validator = new Validator();
        try {
            validator.validate(applicant);
            System.out.println("Application is valid");
        } catch (BankException e) {
            System.out.println(e.getMessage());
        }
    }
}
