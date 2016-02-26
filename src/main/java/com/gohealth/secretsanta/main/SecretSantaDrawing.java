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
		
		System.out.println("Please enter the participant names separated by a comma.  To quit enter 'Q'.\n");
		
		
		String participantNames = null;
		String participants[] = null;
		boolean correctInput = false;
		
		while(!correctInput && !"Q".equals(participantNames)) {
			try {
				BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
				participantNames = bufferRead.readLine();
			
			} catch(IllegalFormatException | IOException e) {
				e.printStackTrace();
			}
		
			if(!participantNames.contains(",")) {
				System.out.println("\nInvalid input for participant names was entered.  List of participant "
					+ "names is required to be comma separated.\n");
				System.out.println("Please try again or enter 'Q' to quit.\n");
				continue;
			}
		
			participants = participantNames.split(",");
		
			if(participants.length < 4) {
				System.out.println("Too few participants were entered. The minimum number of participants allowed is 4 to "
					+ "guarantee each donor gets a valid assignment.");
				System.out.println("Please try again or enter 'Q' to quit.\n");
			} else {
				correctInput = true;
			}
		}
		
		if("Q".equals(participantNames)) {
			System.out.println("\nThank you for using the Secret Santa Drawing program.  Good bye.\n");
			return;
		}
		
		System.out.println("\nPlease enter the algorithm number you want to use for the secret santa drawing. Enter '1' or '2' or enter 'Q' to quit.\n");
		
		
		String algorithmNumber = null;
		String[] assignments = null;
		while(!"1".equals(algorithmNumber) && !"2".equals(algorithmNumber) && !"Q".equals(algorithmNumber)) {
			try {
				BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
				algorithmNumber = bufferRead.readLine();
			} catch(IllegalFormatException | IOException e) {
				e.printStackTrace();
			}
		
			SecretSantaDrawing secretSantaDrawing = new SecretSantaDrawing();
			
			switch(algorithmNumber) {
				case "1":
					assignments = secretSantaDrawing.secretSantaAssignmentGeneratorOne.generateAssignments(participants);
					break;
				case "2":
					assignments = secretSantaDrawing.secretSantaAssignmentGeneratorTwo.generateAssignments(participants);
					break;
				case "Q":
					break;
				default:
					System.out.println("Invalid input was entered. Please try again or enter Q to exit.");
					break;
			}
		}
		
		if("Q".equals(algorithmNumber)) {
			System.out.println("\nThank you for using the Secret Santa Drawing program.  Good bye.\n");
			return;
		}
		
		System.out.println("\nList of participants:");
		
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
		
		System.out.println("\nList of assignments:");
		
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
		
		System.out.println("\nThank you for using the Secret Santa Drawing program.  Good bye.\n");
	}
	
}
