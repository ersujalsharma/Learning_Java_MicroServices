package com.sujal.service;

import java.util.Map;

import com.sujal.exception.SujalAcademyException;
import com.sujal.model.Candidate;
import com.sujal.model.CandidateReport;

public interface CandidateService {
	public abstract String addCandidate(Candidate candidate) throws SujalAcademyException;
	public abstract String calculateGrade(CandidateReport candidateReportTO);
	public abstract Map<Integer, String> getGradesForAllCandidates() throws SujalAcademyException;
}
