package com.sujal.dao;

import java.util.List;

import com.sujal.model.Candidate;
import com.sujal.model.CandidateReport;

public interface CandidateDAO {
	String addCandidate(Candidate candidates);
	List<CandidateReport> getAllCandidates();
}
