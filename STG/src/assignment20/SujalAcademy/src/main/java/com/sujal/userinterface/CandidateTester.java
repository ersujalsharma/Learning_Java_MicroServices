package com.sujal.userinterface;

import java.time.LocalDate;

import com.sujal.model.Candidate;
import com.sujal.service.CandidateService;
import com.sujal.service.CandidateServiceImpl;



/**
 * Creates the user object and calls the methods in the service class. This is a
 * temporary class and will be replaced once the client tier is developed
 * 
 * @author ETA
 */

public class CandidateTester {
	

	public static void main(String[] args) throws Exception {
//		Kindly uncomment the below code after implementing the complete code
   	 addCandidates();
  	 getGradesForAllCandidates();
	}

	public static void addCandidates() throws Exception  {
		
		String message = null;
		try {
			CandidateService candidateService = new CandidateServiceImpl();
			
			LocalDate examDate = LocalDate.of(2014, 5, 29);
			Candidate candidate = new Candidate(
					12346, "Sam", 51, 56, 78, 'P', "ECE", examDate);
			
			message = candidateService.addCandidate(candidate);
	
			System.out.println(message);
		} catch (Exception  e) {
		
			System.out.println(e.getMessage());
		}
	}

	public static void getGradesForAllCandidates() throws Exception{
		try {
		CandidateService candidateService = new CandidateServiceImpl();
		String[] allCandidatesMap = candidateService.getGradesForAllCandidates();
		System.out.println("\tCandidate ID\t\tResult");
		System.out.println("\t************\t\t******");
		for (String candidateReport : allCandidatesMap) {
			String candidateId = candidateReport.split(":")[0];
			String candidateGrade = candidateReport.split(":")[1];
			System.out.println("\t" + candidateId + "\t\t\t" + candidateGrade);
		}

		} catch (Exception e) {
			System.out.println("\t\t"+e.getMessage());
		}
	}

}
