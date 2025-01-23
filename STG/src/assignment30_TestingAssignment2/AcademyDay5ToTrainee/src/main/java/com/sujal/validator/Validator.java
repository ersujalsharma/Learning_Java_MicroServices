package com.sujal.validator;

import java.time.LocalDate;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sujal.exception.AcademyException;
import com.sujal.model.Candidate;


public class Validator {
//	Log all the details of the exceptions being thrown from the validate() method of this class. 
	public static Log LOGGER = LogFactory.getLog(Validator.class); 
	
//	Make sure to let every exception propagate.
	public void validate(Candidate candidate) throws AcademyException {
		String errorStatus =  null	;
		if(!isValidCandidateName(candidate.getCandidateName())) {
			errorStatus = "Validator.INVALID_CANDIDATE_NAME";
		}
		else if(!isValidCandidateId(candidate.getCandidateId())) {
			errorStatus = "Validator.INVALID_CANDIDATE_ID";
		}
		else if(!isValidDepartment(candidate.getDepartment())) {
			errorStatus = "Validator.INVALID_DEPARTMENT";
		}
		else if(!isValidExamDate(candidate.getExamDate())) {
			errorStatus = "Validator.INVALID_EXAM_DATE";
		}
		else if(!isValidExamMarks(candidate)) {
			errorStatus = "Validator.INVALID_EXAM_MARKS";
		}
		else if(!isValidResult(candidate.getResult())) {
			errorStatus = "Validator.INVALID_RESULT";
		}
		if (errorStatus != null) {
			throw new AcademyException(errorStatus);
		}
	}	
	// The entered candidate name should contain only alphabets. Cannot have
	// special characters and only spaces
	public Boolean isValidCandidateName(String candidateName) {
		return candidateName.matches("[A-Za-z]+");
	}

	// The entered candidate ID should be of size 5
	public Boolean isValidCandidateId(Integer candidateId) {
		return candidateId.toString().length() == 5;
	}

	// The entered Department name should be one among the given departments
	// (ECE, CSE, IT, EEE)
	public Boolean isValidDepartment(String department) {
		return department.matches("(ECE|CSE|IT|EEE)");
	}

	// exam date cannot be today or after todays date
	public Boolean isValidExamDate(LocalDate examDate) {
		return examDate.isBefore(LocalDate.now());
	}
	
	//Checking if marks are not equal to "0"
	public Boolean isValidExamMarks(Candidate candidateTO) {
		return candidateTO.getMark1()>0 && candidateTO.getMark2()>0
				&& candidateTO.getMark3()>0;
	}
	
	//Checking if result set is either 'P' or 'F' only
	public Boolean isValidResult(Character result) {
		return result.toString().matches("P|F");
	}


}
