package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.sujal.exception.AcademyException;

import application.EmailValidator;

public class EmailValidatorTest {
	

	EmailValidator emailValidator = new EmailValidator();
	
	@Test
	public void validateEmailIdValidEmailId() throws AcademyException {
		//add your code here
		String string = "Jame_Potter@infy.com";
		boolean val = emailValidator.validateEmailId(string);
		Assertions.assertTrue(val);
	}
	
	@Test
	public void validateEmailIdInvalidEmailId() throws AcademyException {
		//add your code here
		String string = "Jame_Potter@infy.org";
		boolean val = emailValidator.validateEmailId(string);
		Assertions.assertFalse(val);
	}
	
	@Test
	public void validateEmailIdInvalidEmailIdException() throws AcademyException {
		//add your code here
		String emaild = null;
		AcademyException academyException = Assertions.assertThrows(AcademyException.class, ()->emailValidator.validateEmailId(emaild));
		Assertions.assertEquals(academyException.getMessage(), "Invalid Email ID");
	}
	
	@ParameterizedTest
	@CsvSource(value={"Sirius_Black","Lily_Evans@Hoggy.in","Remus_Lups","NymphieTonks@magic.com"})
	public void validateEmailIdParamterizedEmailId(String emailId) throws AcademyException {
		//add your code here
		boolean val = emailValidator.validateEmailId(emailId);
		if(!val) Assertions.assertFalse(val);
		else Assertions.assertTrue(val);
	}
}
