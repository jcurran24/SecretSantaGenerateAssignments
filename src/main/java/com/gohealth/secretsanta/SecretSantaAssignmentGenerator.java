package com.gohealth.secretsanta;

/**
 * SecretSantaAssignmentsGenerator
 * - An interface for generation of assignments, in a secret santa drawing,
 *   per a list of participants.
 *   
 * @author jeremycurran
 *
 */
public interface SecretSantaAssignmentGenerator {

	/**
	 * - generateAssignments
	 *   - Generates an array of assignments mapped to each donor in the array of participants
	 *     by array index.  Each assignment is unique and each donor is assigned a participant
	 *     that is not themself.
	 * @param participants list of individuals participating in the draw.
	 * @return the list of individuals paired with the participants where participants[0]
	 * is matched with assignments[0], participants[1] is matched with assignments[1], and so on.
	 */
	public String[] generateAssignments(final String[] participants);
	
}
