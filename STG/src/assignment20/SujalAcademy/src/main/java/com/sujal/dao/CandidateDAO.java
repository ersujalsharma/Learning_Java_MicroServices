package com.sujal.dao;

import com.sujal.model.Candidate;
import com.sujal.model.CandidateReport;

public interface CandidateDAO {
	public abstract String addCandidate(Candidate candidates);
	public abstract CandidateReport[] getAllCandidates();
}
