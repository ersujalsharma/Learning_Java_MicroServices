package com.sujal.userinterface;

import java.time.LocalDate;
import java.util.Map;
import java.util.Set;

import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.fluent.Configurations;

import org.apache.commons.configuration2.ex.ConfigurationException;
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
		// addCandidates();
		 getGradesForAllCandidates();
	}
    //you will get to know about properties very soon
	public static void addCandidates() throws ConfigurationException {
		PropertiesConfiguration config = new Configurations().properties("configuration.properties");
		String message = null;
		try {
			CandidateService candidateService = new CandidateServiceImpl();
			
			LocalDate examDate = LocalDate.of(2014, 5, 29);
			Candidate candidate = new Candidate(
					12346, "Sam", 80, 78, 60, 'P', "ECE", examDate);
			
			message = candidateService.addCandidate(candidate);
	
			System.out.println(config.getProperty(message));
		} catch (Exception e) {
			System.out.println(config.getProperty(e.getMessage()));
		}
	}
	//you will get to know about properties very soon
	public static void getGradesForAllCandidates() throws ConfigurationException {
		PropertiesConfiguration config = new Configurations().properties("configuration.properties");
		try {
			CandidateService candidateService = new CandidateServiceImpl();
			Map<Integer, String> allCandidatesMap = candidateService
					.getGradesForAllCandidates(); 
			System.out.println("\tCandidate ID\t\tResult");
			System.out.println("\t************\t\t******");
			Set<Integer> set = allCandidatesMap.keySet();
			for (Integer candidateId : set) {
				System.out.println("\t"+candidateId + "\t\t\t"
						+ allCandidatesMap.get(candidateId));
			}

		} catch (Exception e) {
			System.out.println("\t\t"+config.getProperty(e.getMessage()));
		}
	}

}
