package com.sujal.validator;

import java.time.LocalDate;

import com.sujal.model.Candidate;

public class Validator {
	//calls the validation methods for individual inputs
	//if any method returns false, then the String value correspondingly
	public String validate(Candidate candidate) {	
		if (!isValidCandidateName(candidate.getCandidateName())) {
			return "The entered candidate name is invalid.";
		}
		if (!isValidCandidateId(candidate.getCandidateId())) {
			return "The entered candidate ID is invalid.";
		}
		if (!isValidDepartment(candidate.getDepartment())) {
			return "The entered Department name is invalid.";
		}
		if (!isValidExamDate(candidate.getExamDate())) {
			return "The entered Exam Date is invalid.";
		}
		if (!isValidExamMarks(candidate)) {
			return "The entered exam marks are invalid.";
		}
		if (!isValidResult(candidate.getResult())) {
			return "The entered result is invalid.";
		}
		return null;
	}	

	// The entered candidate name should contain only alphabets. Cannot have
	// special characters and only spaces
	public Boolean isValidCandidateName(String candidateName) {
		return candidateName.matches("[a-zA-Z]+");
	}

	// The entered candidate ID should be of size 5
	public Boolean isValidCandidateId(Integer candidateId) {
		return candidateId.toString().length() == 5;
	}

	// The entered Department name should be one among the given departments
	// (ECE, CSE, IT, EEE)
	public Boolean isValidDepartment(String department) {
		return department.matches("ECE|CSE|IT|EEE");
	}

	// exam date cannot be today or after todays date
	public Boolean isValidExamDate(LocalDate examDate) {
		return examDate.isBefore(LocalDate.now());
	}
	
	//Checking if marks are not equal to "0"
	public Boolean isValidExamMarks(Candidate candidateTO) {
		return candidateTO.getMark1() > 0 && candidateTO.getMark2() > 0 && candidateTO.getMark3() > 0;
	}
	
	//Checking if result set is either 'P' or 'F' only
	public Boolean isValidResult(Character result) {
		return result == 'P' || result == 'F';
	}


}
