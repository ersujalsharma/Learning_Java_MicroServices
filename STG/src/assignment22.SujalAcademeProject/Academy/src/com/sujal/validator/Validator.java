package com.sujal.validator;

import java.time.LocalDate;

import com.sujal.exception.SujalAcademyException;
import com.sujal.model.Candidate;

public class Validator {

	public void validate(Candidate candidate) throws SujalAcademyException {
		if(!isValidCandidateId(candidate.getCandidateId())) {
			throw new SujalAcademyException("The entered candidate ID is invalid");
		}
		if(!isValidCandidateName(candidate.getCandidateName())) {
			throw new SujalAcademyException("The entered candidate name is invalid");
		}
		if(!isValidDepartment(candidate.getDepartment())) {
			throw new SujalAcademyException("The entered department is invalid");
		}
		if(!isValidExamDate(candidate.getExamDate())) {
			throw new SujalAcademyException("The entered exam date is invalid");
		}
		if(!isValidExamMarks(candidate)) {
			throw new SujalAcademyException("The entered exam marks are invalid");
		}
		if(!isValidResult(candidate.getResult())) {
			throw new SujalAcademyException("The entered result is invalid");
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
