package com.sujal.validator;

import java.time.LocalDate;

import com.sujal.exception.SujalAcademyException;
import com.sujal.model.Candidate;
//This class has been completely implemented for you. 
//But we have used conditional statements everywhere.
//Please convert these statements to ternary operators or stream
//functions where ever possible.
public class Validator {
	 //Observe the exception message and compare with InfyAcademyDay3_ToTrainee

	public void validate(Candidate candidate) throws SujalAcademyException {
		String errorStatus;
		if (!isValidCandidateName(candidate.getCandidateName())) 
			errorStatus = "Validator.INVALID_CANDIDATE_NAME";
		else if (!isValidCandidateId(candidate.getCandidateId()))
			errorStatus = "Validator.INVALID_CANDIDATE_ID";
		else if (!isValidDepartment(candidate.getDepartment()))
			errorStatus = "Validator.INVALID_DEPARTMENT";
		else if (!isValidExamDate(candidate.getExamDate()))
			errorStatus = "Validator.INVALID_EXAM_DATE";
		else if (!isValidExamMarks(candidate))
			errorStatus = "Validator.INVALID_EXAM_MARKS";
		else if (!isValidResult(candidate.getResult()))
			errorStatus = "Validator.INVALID_RESULT";
		else 
			errorStatus = null;
		if (errorStatus != null) {
			
			throw new SujalAcademyException(errorStatus);
		}
	}	

	
	public Boolean isValidCandidateName(String candidateName) {
		return candidateName.matches("[A-Za-z]+");
	}

	
	public Boolean isValidCandidateId(Integer candidateId) {
		return candidateId.toString().length() == 5;
	}

	
	public Boolean isValidDepartment(String department) {
		return department.matches("(ECE|CSE|IT|EEE)");
	}


	public Boolean isValidExamDate(LocalDate examDate) {
		return examDate.isBefore(LocalDate.now());
	}
	
	public Boolean isValidExamMarks(Candidate candidateTO) {
		return candidateTO.getMark1()>0 && candidateTO.getMark2()>0
				&& candidateTO.getMark3()>0;
	}
	
	
	public Boolean isValidResult(Character result) {
		return result.toString().matches("P|F");
	}


}
