package assignment3.academy.service;

import assignment3.academy.dao.CandidateDAO;
import assignment3.academy.model.Candidate;
import assignment3.academy.model.CandidateReport;

public class CandidateService {

	CandidateDAO candidateDAO = new CandidateDAO();
	// can have result as 'P' only if all 3 marks are 50 and above
	public String addCandidate(Candidate candidate) {
		if ((candidate.getMark1() < 50 || candidate.getMark2() < 50 || candidate.getMark3() < 50) && candidate.getResult() == 'P') {
			return "Result should be 'F' (Fail) if student scores less than 50 in any one subject";
		}
		return candidateDAO.addCandidate(candidate);
	}

	// calculating grade for candidate based on his marks and result
	public String calculateGrade(CandidateReport candidateReportTO) {
		if (candidateReportTO.getResult() == 'F') return "NA";
		int avg = (candidateReportTO.getMark1()+candidateReportTO.getMark2()+candidateReportTO.getMark3())/3;
		if(avg>=85) return "A";
		if(avg>=75){
			return "B";
		}
		return "C";
	}

	// populating String[] by calling calculateGrade(candidateReportTO) and returning the same.
	public String[] getGradesForAllCandidates() {
		CandidateReport[] candidateReports = candidateDAO.getAllCandidates();
		String arr[] = new String[candidateReports.length];
		for (int i = 0; i < candidateReports.length; i++) {
			arr[i] = candidateReports[i].getCandidateId() + ":" + calculateGrade(candidateReports[i]);
		}
		return arr;
	}
}
