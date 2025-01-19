package com.sujal.dao;

import java.util.List;

import com.sujal.exception.SujalAcademyException;
import com.sujal.model.Candidate;
import com.sujal.model.CandidateReport;

public interface CandidateDAO {
	public abstract String addCandidate(Candidate candidates) throws SujalAcademyException;
	public abstract List<CandidateReport> getAllCandidates() throws SujalAcademyException;
}
