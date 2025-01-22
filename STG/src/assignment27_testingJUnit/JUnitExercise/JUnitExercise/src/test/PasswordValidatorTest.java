package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.sujal.exception.AcademyException;

import application.PasswordValidator;

public class PasswordValidatorTest {
	
	PasswordValidator passwordValidator = new PasswordValidator();
	
	@Test
	public void validatePasswordValidPassword() throws AcademyException {
		//add your code here
		String password = "Asdfe123";
		boolean val = passwordValidator.validatePassword(password);
		Assertions.assertTrue(val);
	}
	@Test
	public void validatePasswordInvalidPassword() throws AcademyException {
		//add your code here
		String password = "Asdf";
		boolean val = passwordValidator.validatePassword(password);
		Assertions.assertFalse(val);
	}
	@Test
	public void validatePasswordInvalidPasswordException() throws AcademyException {
		//add your code here
		String password = null;
		AcademyException academyException = Assertions.assertThrows(AcademyException.class, ()->passwordValidator.validatePassword(password));
		Assertions.assertEquals(academyException.getMessage(), "Invalid Password.");
	}
	@ParameterizedTest
	@CsvSource(value={"Qwerty","Qwerty1234","QwertyAsdfZxcvVcxzFdsaRewq","Zxcvb54321"})
	public void validatePasswordParameterizedPassword(String password) throws AcademyException {
		//add your code here
		boolean val = passwordValidator.validatePassword(password);
		if(val)
		Assertions.assertTrue(val);
		else Assertions.assertFalse(val);
	}
}