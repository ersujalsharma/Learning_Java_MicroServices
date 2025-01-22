package test.votingValidator;

import application.VoterValidator;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

//public class VotingValidatorTest {
//    @Test
//    public void validateVoterAgeValidTest() throws Exception{
//        int age = 18;
//        VoterValidator voterValidator = new VoterValidator();
//        boolean expectedResult = true;
//        boolean actual = voterValidator.validateVoterAge(age);
//        Assertions.assertEquals(actual, expectedResult);
//    }
//
//    @ParameterizedTest
//    @CsvSource(value = {"19,true","20,true","17,false","16,false"})
//    public void validateVoterAgeTestParameter(int age,boolean expected) throws Exception{
//        VoterValidator voterValidator = new VoterValidator();
//        boolean actual = voterValidator.validateVoterAge(age);
//        Assertions.assertEquals(actual, expected);
//    }
//
//    @Test
//    public void validateVoterAgeInvalidTest() throws Exception {
//	    int age = 17;
//	    VoterValidator voterValidator = new VoterValidator();
//	    boolean result = voterValidator.validateVoterAge(age);
//        Assertions.assertFalse(result);
//    }
//    @Test
//    public void validateVoterAgeInvalidTest2() throws Exception {
//    	int age = -14;
//    	VoterValidator voterValidator = new VoterValidator();
//    	Exception exception = Assertions.assertThrows(Exception.class, () -> voterValidator.validateVoterAge(age));
//        Assertions.assertEquals("Invalid age", exception.getMessage());
//    }
//    @ParameterizedTest
//    @CsvSource(value = {"-1","-5","-20"})
//    public void validateVoterAgeInvalidTest2Parameter(int age) throws Exception {
//    	VoterValidator voterValidator = new VoterValidator();
//    	Exception exception = Assertions.assertThrows(Exception.class, () -> voterValidator.validateVoterAge(age));
//        Assertions.assertEquals("Invalid age", exception.getMessage());
//    }
//
//}
public class VotingValidatorTest {

    private static int counter;

    @BeforeAll
    public static void beforeMethod() {
        System.out.println("Before test cases");
    }
    @BeforeEach
    public void beforeEachMethod() {
        System.out.println("Before test case "+(++counter));
    }
    @Test
    public void validateVoterAgeValidTest() throws Exception {
        int age = 18;
        VoterValidator voterValidator = new VoterValidator();
        Assertions.assertTrue(voterValidator.validateVoterAge(age));
    }
    
	@Test
  public void validateVoterAgeInvalidTest() throws Exception {
	    int age = 17;
	    VoterValidator voterValidator = new VoterValidator();
	    boolean result = voterValidator.validateVoterAge(age);
      Assertions.assertFalse(result);
  }
    
    @AfterEach
    public void afterEachMethod() {
        System.out.println("After test case "+(counter));
    }

    @AfterAll
    public static void afterMethod() {
        System.out.println("After test cases");
    }

}