package com.gohealth.secretsanta;

import org.junit.Test;


public class SecretSantaAssignmentGeneratorImplTwoTest extends SecretSantaAssignmentGeneratorImplTest {

	
	public SecretSantaAssignmentGeneratorImplTwoTest() {
		super();
		this.assignmentGenerator = new SecretSantaAssignmentGeneratorImplTwo();
	}
	
	@Test
	public void testGenerateAssignmentsParticipantsNotNull() {
		super.testGenerateAssignmentsParticipantsNotNull();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGenerateAssignmentsParticipantsNull() {
		super.testGenerateAssignmentsParticipantsNull();
	}
	
	@Test
	public void testGenerateAssignmentsAndParticipantsSameSize() {
		super.testGenerateAssignmentsAndParticipantsSameSize();
	}
	
	@Test
	public void testGenerateAssignments() {
		super.testGenerateAssignments();
	}
	
	
	@Test
	public void testGenerateAssignmentsForPermutations() {
		super.testGenerateAssignmentsForPermutations();
	}

}
