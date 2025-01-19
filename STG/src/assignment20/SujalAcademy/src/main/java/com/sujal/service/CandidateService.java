package com.sujal.service;


import com.sujal.model.Candidate;
import com.sujal.model.CandidateReport;

public interface CandidateService {
	public abstract String addCandidate(Candidate candidate) throws Exception;
	public abstract String calculateGrade(CandidateReport candidateReportTO);
	public abstract String[] getGradesForAllCandidates() ;
}
