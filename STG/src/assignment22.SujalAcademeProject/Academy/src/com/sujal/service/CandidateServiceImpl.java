package com.sujal.service;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.sujal.dao.CandidateDAO;
import com.sujal.dao.CandidateDAOImpl;
import com.sujal.exception.SujalAcademyException;
import com.sujal.model.Candidate;
import com.sujal.model.CandidateReport;
import com.sujal.validator.Validator;

public class CandidateServiceImpl implements CandidateService {
	private CandidateDAO candidateDAO = new CandidateDAOImpl();
	// can have status as 'P' only if all 3 marks are 50 and above
	public String addCandidate(Candidate candidate) throws SujalAcademyException {
		Validator validator = new Validator();
		validator.validate(candidate);
		Character result = candidate.getResult();
		if (result == 'P') {
			if (candidate.getMark1() < 50 || candidate.getMark2() < 50 || candidate.getMark3() < 50) {
				throw new SujalAcademyException("Result should be 'F' (Fail) if student scores less than 50 in any one subject");
			}
		}
		return candidateDAO.addCandidate(candidate);
	}

	// calculating grade for candidate based on his marks and result
	public String calculateGrade(CandidateReport candidateReportTO) {
		String grade = null;
		if (candidateReportTO.getResult() == 'F') {
			grade = "NA";
		} else {
			float average = (candidateReportTO.getMark1() + candidateReportTO.getMark2() + candidateReportTO.getMark3())
					/ 3f;
			if(average >= 85.0)
				grade= "A";
			else if(average >= 75.0 && average < 85.0)
				grade= "B";
			else
				grade="C";
		}
		return grade;
	}

	// populating map<CandidateId, Grade> by calling
	// calculateGrade(candidateReportTO) and returning the same.
	public Map<Integer, String> getGradesForAllCandidates() throws SujalAcademyException {
		List<CandidateReport> candidateReportList = candidateDAO.getAllCandidates();
		Map<Integer, String> candidateGradeMap = new TreeMap<>();
		for (CandidateReport candidateReportTO : candidateReportList) {
			candidateGradeMap.put(candidateReportTO.getCandidateId(), calculateGrade(candidateReportTO));
		}
		return candidateGradeMap;
	}
}
