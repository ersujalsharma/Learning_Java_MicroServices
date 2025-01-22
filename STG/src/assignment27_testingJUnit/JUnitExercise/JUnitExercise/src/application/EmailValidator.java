package application;

import com.sujal.exception.AcademyException;

public class EmailValidator {
	public boolean validateEmailId(String emailId) throws AcademyException {
		
		if(emailId == null || emailId.isBlank())
			throw new AcademyException("Invalid Email ID");
		return emailId.matches("\\w+@\\w+\\.(com|in)");
	}
	
}
