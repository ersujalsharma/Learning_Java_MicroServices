package userinterface;

import com.sujal.exception.AcademyException;

import org.apache.commons.configuration2.ex.ConfigurationException;

import service.BookIssue;

public class Tester {
	public static void main(String[] args) throws AcademyException, ConfigurationException{
		// Uncomment after implementing BookIssue class

		BookIssue b1 = new BookIssue();
		  b1.bookDetails("The Book Thief");
//		 BookIssue b2 = new BookIssue();
//		  b2.bookDetails("The Kite Runner");
//		 BookIssue b3 = new BookIssue();
//		  b3.bookDetails("Greek Goddesses");


	}

}
