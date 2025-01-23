package com.sujal.service;

import java.util.Map;

import com.sujal.exception.AcademyException;
import com.sujal.model.Candidate;
import com.sujal.model.CandidateReport;

public interface CandidateService {
	String addCandidate(Candidate candidate) throws AcademyException;
	String calculateGrade(CandidateReport candidateReportTO);
	Map<Integer, String> getGradesForAllCandidates() throws AcademyException;
}
