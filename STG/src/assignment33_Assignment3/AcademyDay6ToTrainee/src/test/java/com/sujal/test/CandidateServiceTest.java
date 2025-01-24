package com.sujal.test;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import com.sujal.model.Candidate;
import com.sujal.service.CandidateService;
import com.sujal.service.CandidateServiceImpl;

public class CandidateServiceTest {
	
	CandidateService candidateService = new CandidateServiceImpl();
	
	@Test
	public void addCandidateInvalidCandidateID()  {
		LocalDate examDate = LocalDate.of(2014, 5, 29);
		Candidate candidate = new Candidate(
				1234, "Sam", 45, 78, 60, 'F', "ECE", examDate);
		Exception exception = Assertions.assertThrows(Exception.class, () -> candidateService.addCandidate(candidate));
		Assertions.assertEquals("Validator.INVALID_CANDIDATE_ID", exception.getMessage());
	}
	
	@Test
	public void addCandidateInvalidDepartment()  {
		LocalDate examDate = LocalDate.of(2014, 5, 29);
		Candidate candidate = new Candidate(
				12346, "Sam", 45, 78, 60, 'F', "EC", examDate);
		Exception exception = Assertions.assertThrows(Exception.class, () -> candidateService.addCandidate(candidate));
		Assertions.assertEquals("Validator.INVALID_DEPARTMENT", exception.getMessage());
	}
	
	@Test
	public void addCandidateInvalidResult()  {
		LocalDate examDate = LocalDate.of(2014, 5, 29);
		Candidate candidate = new Candidate(
				12346, "Sam", 1, 1, 1, 'P', "ECE", examDate);
		Exception exception = Assertions.assertThrows(Exception.class, () -> candidateService.addCandidate(candidate));
		Assertions.assertEquals("Service.INVALID_RESULT", exception.getMessage());
	}
	
}
