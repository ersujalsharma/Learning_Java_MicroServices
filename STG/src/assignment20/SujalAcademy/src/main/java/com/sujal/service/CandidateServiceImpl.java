package com.sujal.service;


import com.sujal.dao.*;
import com.sujal.model.*;
import com.sujal.validator.Validator;

public class CandidateServiceImpl implements CandidateService{
	
	private CandidateDAO candidateDAO = new CandidateDAOImpl();
	// call validate method() of Validator class before the marks and result verification
	// if String value returned from validate() is not null, 
	// then return the same String value to the CandidateTester class.
	// Make sure the variable used to invoke addCandidate() method of CandidateDAOImpl is the instance variable .
	 
	@Override
	public String addCandidate(Candidate candidate) {
		Validator validator = new Validator();
		String result = validator.validate(candidate);
		if(result!=null){
			return result;
		}
		
	Character tempResult = 'P';
		
		if (candidate.getMark1() < 50 || candidate.getMark2() < 50 || candidate.getMark3() < 50) {
			tempResult = 'F';
		}
		if (!candidate.getResult().equals(tempResult)) {
			return ("Result should be 'F' (Fail) if student scores less than 50 in any one subject");
		}
		
		return candidateDAO.addCandidate(candidate);
	
	
	}

	
	@Override
	public String calculateGrade(CandidateReport candidateReportTO) 
		{
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
	//Make sure the variable used to invoke getAllCandidates() method of CandidateDAOImpl is the instance variable .
	 
	@Override
	public String[] getGradesForAllCandidates() {
	
		CandidateReport[] allCandidates = candidateDAO.getAllCandidates();
		String[] finalArray = new String[allCandidates.length];
		int index = 0;
		for (CandidateReport report : allCandidates) {
			finalArray[index] = report.getCandidateId()+":"+this.calculateGrade(report);
			index++;
		}
		
		return finalArray;
	}
}
