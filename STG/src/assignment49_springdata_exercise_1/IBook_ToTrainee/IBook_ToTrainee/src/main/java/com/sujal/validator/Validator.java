package com.sujal.validator;

import java.time.LocalDate;

import com.sujal.dto.BookDTO;
import com.sujal.exception.sujalBookException;

public class Validator {

	public static void validate(BookDTO bookDTO) throws sujalBookException {
		if(!validateYear(bookDTO.getPublishedYear())) {
			throw new sujalBookException("Validator.INVALID_YEAR");
		}
	}

	public static boolean validateYear(LocalDate year) {
		return year.isBefore(LocalDate.now());
	}

}
