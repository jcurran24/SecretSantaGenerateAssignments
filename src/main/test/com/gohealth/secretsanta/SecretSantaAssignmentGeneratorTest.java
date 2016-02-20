package com.gohealth.secretsanta;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;

import org.junit.Test;

public class SecretSantaAssignmentGeneratorTest {

	private SecretSantaAssignmentGenerator assignmentGenerator = new SecretSantaAssignmentGenerator();
	
	private final String[] participants = new String[] { "Kyle", "Kenny", "Eric", "Stan", "Stewie", "Brian" };
	
	@Test
	public void testGenerateAssignmentsAssignmentsNotNull() {
		final String[] assignments = assignmentGenerator.generateAssignments(participants);
	
		Assert.assertNotNull(assignments);	
	}
	
	@Test
	public void testGenerateAssignmentsAndParticipantsSameSize() {
		final String[] assignments = assignmentGenerator.generateAssignments(participants);
		
		
		Assert.assertTrue("The number of assignments are not equal to the number of participants", assignments.length == participants.length);
	}
	
	@Test
	public void testGenerateAssignmentsAndParticipants() {
		final String[] assignments = assignmentGenerator.generateAssignments(participants);
		
		Set<String> participantSet = getParticipantsSet();
		
		Assert.assertTrue("The number of assignments are not equal to the number of participants", assignments.length == participants.length);
		
		for(int i = 0; i < assignments.length; i++) {
			if(participantSet.contains(assignments[i]) && !participants[i].equals(assignments[i])) {
				participantSet.remove(assignments[i]);
			} else {
				Assert.assertTrue("There is at least 1 person " + assignments[i] + " assigned to 2 different participants", !participantSet.contains(assignments[i]));
				Assert.assertTrue("A participant " + participants[i] + " was assigned to his/herself", participants[i].equals(assignments[i]));
			}
		}
		
	}
	
	private Set<String> getParticipantsSet() {
		Set<String> participantSet = new HashSet<String>();
		
		for(String participant : participants) {
			participantSet.add(participant);
		}
		return participantSet;
	}
	
}
