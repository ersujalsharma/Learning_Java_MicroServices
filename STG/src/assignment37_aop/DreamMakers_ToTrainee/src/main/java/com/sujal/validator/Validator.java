package com.sujal.validator;

import com.sujal.dto.MovieDTO;
import com.sujal.exception.DreamMakersException;

public class Validator {

	public static void validate(MovieDTO movieDTO) throws DreamMakersException {
		if(!validateMovie(movieDTO)) {
			throw new DreamMakersException("Validator.INVALID_NAMES");
		}
	}

	public static Boolean validateMovie(MovieDTO movieDTO) {
		return !movieDTO.getMovieName().isEmpty() && !movieDTO.getDirector().getDirectorName().isEmpty();
	}
}
