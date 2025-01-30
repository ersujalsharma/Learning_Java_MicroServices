package com.sujal.validator;

import com.sujal.dto.AddressDTO;
import com.sujal.dto.UserDTO;
import com.sujal.exception.UsersException;


public class Validator {

	public static void validate(UserDTO userDTO) throws UsersException {
		if (!isValidUserName(userDTO.getUserName()))
			throw new UsersException("Validator.INVALID_USERNAME");
		if (!isValidPassword(userDTO.getPassword()))
			throw new UsersException("Validator.INVALID_PASSWORD");
		if (!isValidEmail(userDTO.getEmail()))
			throw new UsersException("Validator.INVALID_EMAIL");
		if (!isValidMobileNumber(userDTO.getMobileNumber()))
			throw new UsersException("Validator.INVALID_MOBILENO");
		if (!isValidAddress(userDTO.getAddress()))
			throw new UsersException("Validator.INVALID_ADDRESS");
	}

	public static Boolean isValidUserName(String userName) {
		return (userName.matches("[A-Za-z]+([ ][A-Za-z]+)*")) ? true : false;
	}

	public static Boolean isValidPassword(String password) {
		return (password.length() >= 8 && (password.matches("[A-Za-z0-9\\W]*[\\W_]{1,}[A-Za-z0-9\\W]*"))) ? true : false;
	}

	public static Boolean isValidEmail(String email) {
		return email.matches("[\\w]+@[\\w]+\\.[\\w]+") ? true : false;
	}

	public static Boolean isValidMobileNumber(String mobileNo) {
		String pattern1 = mobileNo.charAt(0) + "{10}";
		String pattern2 = "[\\d]{10}";
		return (mobileNo.matches(pattern1) || !mobileNo.matches(pattern2)) ? false : true;
	}

	public static Boolean isValidAddress(AddressDTO address) {
		String zipCode1 = address.getZipCode().toString();
		String pattern1 = zipCode1.charAt(0) + "{5}";
		String pattern2 = "[\\d]{5}";

		return (address.getDoorNumber().trim().isEmpty()
				|| address.getCity().trim().isEmpty()
				|| address.getStreet().trim().isEmpty()
				|| address.getState().trim().isEmpty()
				|| (zipCode1.matches(pattern1) || !zipCode1.matches(pattern2))) ? false : true;
	}
}
