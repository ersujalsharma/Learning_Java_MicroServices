package assignment3.academy.dao;

import assignment3.academy.model.Candidate;
import assignment3.academy.model.CandidateReport;

public class CandidateDAO {
	public String addCandidate(Candidate candidates) {
		return "Candidate details are successfully added.";
	}

	public CandidateReport[] getAllCandidates() {
//		return null;

		CandidateReport candidate = new CandidateReport(80004, "John", 90, 80, 70, 'P', null);
		CandidateReport candidate1 = new CandidateReport(80005, "Marshal", 33, 60, 70, 'F', null);
		CandidateReport candidate2 = new CandidateReport(80002, "Jacob", 99, 80, 90, 'P', null);
		CandidateReport candidate3 = new CandidateReport(80001, "Samuel", 30, 80, 90, 'F', null);
		CandidateReport candidate4 = new CandidateReport(80003, "Jack", 60, 60, 60, 'P', null);

		return new CandidateReport[] {candidate, candidate1, candidate2, candidate3, candidate4};
	}
}
