package com.gohealth.secretsanta.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.IllegalFormatException;

import com.gohealth.secretsanta.SecretSantaAssignmentGenerator;
import com.gohealth.secretsanta.SecretSantaAssignmentGeneratorImpl;
import com.gohealth.secretsanta.SecretSantaAssignmentGeneratorImplTwo;

public class SecretSantaDrawing {
	private SecretSantaAssignmentGenerator secretSantaAssignmentGeneratorOne = new SecretSantaAssignmentGeneratorImpl();
	private SecretSantaAssignmentGenerator secretSantaAssignmentGeneratorTwo = new SecretSantaAssignmentGeneratorImplTwo();
	
	public static void main(String... args) {
		
		System.out.println("Welcome To the Secret Santa Drawing");
		
		System.out.println("Please enter the participant names separated by a comma\n");
		
		
		String participantNames = null;
		try {
			BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
		    participantNames = bufferRead.readLine();
			
		} catch(IllegalFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String participants[] = participantNames.split(",");
		
		System.out.println("\nPlease enter the algorithm number you want to use for the secret santa drawing.\n");
		
		
		String algorithmNumber = null;
		try {
			BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
		    algorithmNumber = bufferRead.readLine();
		} catch(IllegalFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String[] assignments = null;
		
		SecretSantaDrawing secretSantaDrawing = new SecretSantaDrawing();
		
		if("1".equals(algorithmNumber)) {
			assignments = secretSantaDrawing.secretSantaAssignmentGeneratorOne.generateAssignments(participants);
		} else if("2".equals(algorithmNumber)) {
			assignments = secretSantaDrawing.secretSantaAssignmentGeneratorTwo.generateAssignments(participants);
		} else {
			System.out.println("You made an invalid selection. Please rerun this program and try again. Good bye.");
			return;
		}
		
		System.out.println("List of participants:");
		
		int count = 0;
		String participantsList = "";
		for(String participant : participants) {
			participantsList += participant;
			if(count != participants.length - 1) {
				participantsList += ", ";
			}
			count++;
		}
		System.out.println(participantsList);
		
		System.out.println("List of assignments:");
		
		count = 0;
		String assignmentsList = "";
		for(String assignment : assignments) {
			assignmentsList += assignment;
			if(count != participants.length - 1) {
				assignmentsList += ", ";
			}
			count++;
		}
		System.out.println(assignmentsList);
		
		System.out.println("\nThank you for using the Secret Santa Drawing program.  Good bye.");
	}
	
}
