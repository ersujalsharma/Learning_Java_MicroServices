package test.boothValidator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import application.BoothValidator;

public class BoothValidatorTest {
	@Tag("prod")
	@Test
	public void validateBoothDetailsValidTest() throws Exception {
		String boothName = "Booth1";
		BoothValidator boothValidator = new BoothValidator();
		Assertions.assertTrue(boothValidator.validateBoothDetails(boothName));
	}
	
	@Tag("dev")
	@Test
	public void validateBoothDetailsInvalidTest1() throws Exception {
		String boothName = "";
		BoothValidator boothValidator = new BoothValidator();
		Assertions.assertFalse(boothValidator.validateBoothDetails(boothName));
	}
	
	@Tag("dev")
	@Test
	public void validateBoothDetailsInvalidTest2() throws Exception {
		String boothName = null;
		BoothValidator boothValidator = new BoothValidator();
		Exception exception = Assertions.assertThrows(Exception.class, () -> boothValidator.validateBoothDetails(boothName));
		Assertions.assertEquals("Booth name is invalid.", exception.getMessage());
	}

}
