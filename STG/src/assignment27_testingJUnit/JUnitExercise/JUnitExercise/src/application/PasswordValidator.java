package application;

import com.sujal.exception.AcademyException;

public class PasswordValidator {
	public boolean validatePassword(String password) throws AcademyException {
		if(password == null || password.isBlank())
			throw new AcademyException("Invalid Password.");
		return password.matches("[A-Za-z0-9]{8,20}");
	}
}
