package com.sujal.validator;

import java.util.List;


import com.sujal.exception.MobileServiceException;
import com.sujal.model.ServiceRequest;
import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Validator {
	private static final Log LOGGER = LogFactory.getLog(Validator.class);
	Configurations configurations = new Configurations();
	PropertiesConfiguration config;

    {
        try {
            config = configurations.properties("configuration.properties");
        } catch (ConfigurationException e) {
            throw new RuntimeException(e);
        }
    }

    public void validate(ServiceRequest service) throws MobileServiceException{
		//your code goes here
		try {
			if (!isValidBrand(service.getBrand())) {
				throw new MobileServiceException("Validator.INVALID_BRAND");
			}
			if (!isValidIssues(service.getIssues())) {
				throw new MobileServiceException("Validator.INVALID_NO_OF_ISSUES");
			}
			if (!isValidIMEINumber(service.getiMEINumber())) {
				throw new MobileServiceException("Validator.INVALID_IMEI_NUMBER");
			}
			if (!isValidContactNumber(service.getContactNumber())) {
				throw new MobileServiceException("Validator.INVALID_CONTACT_NUMBER");
			}
			if (!isValidCustomerName(service.getCustomerName())) {
				throw new MobileServiceException("Validator.INVALID_CUSTOMER_NAME");
			}
		} catch (MobileServiceException e) {
			LOGGER.error(config.getProperty(e.getMessage()));
			throw e;
		}
	}	

	
	// validates the brand
	// brand should always start with a upper case alphabet 
	// and can be followed by one or more alphabets (lower case or upper case) 
	public Boolean isValidBrand(String brand){
		return brand.matches("[A-Z]+[A-Za-z]+");
	}
	
	
	// validates the list of issues
	// checks if the list is null or empty
	public Boolean isValidIssues(List<String> issues) {
		return issues!=null && !issues.isEmpty();
	}

	// validates the IMEINumber
	// it should be a 16 digit number 
	public Boolean isValidIMEINumber(Long iMEINumber) {
		return iMEINumber.toString().length()==16;
	}
	
	// validates the contact number
	// should contain 10 numeric characters and should not contain 10 repetitive characters
	public Boolean isValidContactNumber(Long contactNumber) {
		return contactNumber.toString().matches("[0-9]{10}") && !contactNumber.toString().matches("([0-9])\\1{9}");
	}
	
	
	// validates the customer name
	// should contain at least one word and each word separated by a single space should contain at least one letter.
	// the first letter of every word should be an upper case character 
	public Boolean isValidCustomerName(String customerName) {
		return customerName.matches("([A-Z][a-z]+\\s?)+");
	}
}
