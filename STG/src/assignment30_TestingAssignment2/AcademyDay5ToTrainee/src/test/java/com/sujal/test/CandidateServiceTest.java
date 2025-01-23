package com.sujal.test;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.sujal.exception.AcademyException;
import com.sujal.model.Candidate;
import com.sujal.service.CandidateServiceImpl;

public class CandidateServiceTest {
	@Test
	public void addCandidateInvalidCandidateID() throws AcademyException {
		//Code here
		CandidateServiceImpl candidateServiceImpl = new CandidateServiceImpl();
		Candidate candidate = new Candidate(1234, "Sam", 51, 56, 78, 'P', "ECE", LocalDate.of(2014, 5, 29));
	    AcademyException exception = Assertions.assertThrows(AcademyException.class, ()->candidateServiceImpl.addCandidate(candidate));
	    Assertions.assertEquals(exception.getMessage(), "Validator.INVALID_CANDIDATE_ID");
	}
	@Test
	public void addCandidateInvalidDepartment() throws AcademyException {
		//Code here
		CandidateServiceImpl candidateServiceImpl = new CandidateServiceImpl();
		Candidate candidate = new Candidate(12345, "Sam", 51, 56, 78, 'P', "EC", LocalDate.of(2014, 5, 29));
	    AcademyException exception = Assertions.assertThrows(AcademyException.class, ()->candidateServiceImpl.addCandidate(candidate));
	    Assertions.assertEquals(exception.getMessage(), "Validator.INVALID_DEPARTMENT");
	}
	@Test
	public void addCandidateInvalidResult() throws AcademyException {
		//Code here
		CandidateServiceImpl candidateServiceImpl = new CandidateServiceImpl();
		Candidate candidate = new Candidate(12345, "Sam", 51, 6, 78, 'P', "ECE", LocalDate.of(2014, 5, 29));
	    AcademyException exception = Assertions.assertThrows(AcademyException.class, ()->candidateServiceImpl.addCandidate(candidate));
	    Assertions.assertEquals(exception.getMessage(), "Service.INCORRECT_RESULT");
	}
	
}
