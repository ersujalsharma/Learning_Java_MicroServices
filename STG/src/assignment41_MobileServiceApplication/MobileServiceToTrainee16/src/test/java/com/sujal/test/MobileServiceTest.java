package com.sujal.test;

import com.sujal.exception.MobileServiceException;
import com.sujal.model.ServiceRequest;
import com.sujal.service.MobileService;
import com.sujal.service.MobileServiceImpl;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;

public class MobileServiceTest {

    private MobileService mobileService= new MobileServiceImpl();
	@Test
	public void registerRequestInvalidBrandTest() {
		//your code goes here
		ServiceRequest serviceRequest = new ServiceRequest("abc", Arrays.asList("BATTERY"), 9876765487L, "John", 1234567890123456L);
		Exception exc = Assertions.assertThrows(MobileServiceException.class,()->mobileService.registerRequest(serviceRequest));
		Assertions.assertEquals("Validator.INVALID_BRAND",exc.getMessage());
	}
	@Test
	public void registerRequestInvalidContactNumberTest() {
		//your code goes here
		ServiceRequest serviceRequest = new ServiceRequest("Twoplusone", Arrays.asList("BATTERY"), 78757L, "John", 1234567890123456L);
		Exception exc = Assertions.assertThrows(MobileServiceException.class,()->mobileService.registerRequest(serviceRequest));
		Assertions.assertEquals("Validator.INVALID_CONTACT_NUMBER",exc.getMessage());
	}
	@Test
	public void registerRequestInvalidIssuesTest() {
		//your code goes here
		ServiceRequest serviceRequest = new ServiceRequest("Twoplusone", Arrays.asList("Broken screen"), 9876765487L, "John", 1234567890123456L);
		Exception exc = Assertions.assertThrows(MobileServiceException.class,()->mobileService.registerRequest(serviceRequest));
		Assertions.assertEquals("Service.INVALID_ISSUES",exc.getMessage());
	}

}
