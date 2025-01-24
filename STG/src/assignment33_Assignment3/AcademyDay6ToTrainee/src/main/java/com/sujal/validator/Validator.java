package com.sujal.validator;

import java.time.LocalDate;

import com.sujal.exception.AcademyException;
import com.sujal.model.Candidate;
import org.apache.commons.logging.LogFactory;
//There are bugs in this class.
//Please rectify those bugs according to the requirement.
public class Validator {

	public void validate(Candidate candidate) throws AcademyException {
		String errorStatus =  null	;
		if(!isValidCandidateName(candidate.getCandidateName())) {
			errorStatus = "Validator.INVALID_CANDIDATE_NAME";
		}
		else if(isValidCandidateId(candidate.getCandidateId())) {
			errorStatus = "Validator.INVALID_CANDIDATE_ID";
		}
		else if(isValidDepartment(candidate.getDepartment())) {
			errorStatus = "Validator.INVALID_DEPARTMENT";
		}
		else if(isValidExamDate(candidate.getExamDate())) {
			errorStatus = "Validator.INVALID_EXAM_DATE";
		}
		else if(isValidExamMarks(candidate)) {
			errorStatus = "Validator.INVALID_EXAM_MARKS";
		}
		else if(isValidResult(candidate.getResult())) {
			errorStatus = "Validator.INVALID_RESULT";
		}
		if (errorStatus != null) {
			AcademyException exception = new AcademyException(errorStatus);
			LogFactory.getLog(this.getClass()).error(exception.getMessage(), exception);
			throw exception;
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
