package assignment21.exceptionalHandling;

public class Validator {
    public void validate(Applicant applicant) throws BankException{
        if(!isValidName(applicant.getApplicantName())){
            throw new BankException("Invalid application name");
        }
        if(!isValidPost(applicant.getPostAppied())){
            throw new BankException("Invalid post applied");
        }
        if(!isValidAge(applicant.getApplicantAge())) {
            throw new BankException("Invalid age exception");
        }
    }
    public boolean isValidName(String name){
        return name!=null && !name.isEmpty();
    }
    public boolean isValidPost(String post){
        return post .equals("Probationary Officer") || post.equals("Assistant")|| post.equals("Special Cadre Officer");
    }
    public boolean isValidAge(int age){
        return age>18 && age<35;
    }

}
