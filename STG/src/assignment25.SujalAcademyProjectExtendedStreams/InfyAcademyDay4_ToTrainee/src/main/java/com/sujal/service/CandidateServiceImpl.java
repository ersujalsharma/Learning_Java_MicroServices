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
//This class has been completely implemented for you.
//But we have used conditional statements and iterative statements. 
//Please convert these statements to ternary operators or 
//stream functions where ever possible.
public class CandidateServiceImpl implements CandidateService {

	private CandidateDAO candidateDAO = new CandidateDAOImpl();

	 //Observe the exception message and compare with InfyAcademyDay3_ToTrainee

	public String addCandidate(Candidate candidate) throws SujalAcademyException {
		Validator validator = new Validator();
		
			validator.validate(candidate);
			Character tempResult = 'P';
			if (candidate.getMark1() < 50 || candidate.getMark2() < 50 || candidate.getMark3() < 50) {
				tempResult = 'F';
			}
			if (!candidate.getResult().equals(tempResult)) {
				throw new SujalAcademyException("Service.INCORRECT_RESULT");
			}
			return candidateDAO.addCandidate(candidate);
		
	}

	
	public String calculateGrade(CandidateReport candidateReportTO) {
		String grade = null;
//		if (candidateReportTO.getResult() == 'F') {
//			grade = "NA";
//		} else {
//			float average = (candidateReportTO.getMark1() + candidateReportTO.getMark2() + candidateReportTO.getMark3()) / (float)3;
//			if (average >= 85.0)
//				grade = "A";
//			else if (average >= 75.0 && average < 85.0)
//				grade = "B";
//			else
//				grade = "C";
//		}
		grade = candidateReportTO.getResult() == 'F' ? "NA" : ((candidateReportTO.getMark1() + candidateReportTO.getMark2() + candidateReportTO.getMark3()) / (float)3 >= 85.0 ? "A" : ((candidateReportTO.getMark1() + candidateReportTO.getMark2() + candidateReportTO.getMark3()) / (float)3 >= 75.0 ? "B" : "C"));
		return grade;
	}

	
	public Map<Integer, String> getGradesForAllCandidates() throws SujalAcademyException {

		List<CandidateReport> allCandidates = candidateDAO.getAllCandidates();
		Map<Integer, String> finalList = new TreeMap<>();
//		for (CandidateReport candidateReport : allCandidates) {
//			finalList.put(candidateReport.getCandidateId(), this.calculateGrade(candidateReport));
//		}
		Map<Integer, String> finalList2 = new TreeMap<>();
				allCandidates.stream().forEach(candidateReport -> finalList2.put(candidateReport.getCandidateId(), this.calculateGrade(candidateReport)));
		return finalList2;
	}
}
