package test;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({EmailValidatorTest.class,PasswordValidatorTest.class})
public class TestSuite {

}