package com.gohealth.secretsanta;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

/**
 * SecretSantaAssignmentsGeneratorImpl
 * - An implementation of an interface for generation of assignments, in a secret santa drawing,
 *   per a list of participants.
 *   
 * @author jeremycurran
 *
 */
public class SecretSantaAssignmentGeneratorImpl implements SecretSantaAssignmentGenerator {

	
	/**
	 * - generateAssignments
	 *   - Generates an array of assignments mapped to each donor in the array of participants
	 *     by array index.  Each assignment is unique and each donor is assigned a participant
	 *     that is not themself.
	 * @param participants list of individuals participating in the draw.
	 * @return the list of individuals paired with the participants where participants[0]
	 * is matched with assignments[0], participants[1] is matched with assignments[1], and so on.
	 */
	public String[] generateAssignments(final String[] participants) {
		if(participants == null) {
			throw new IllegalArgumentException("Particpants array was null");
		}
		
		Set<Integer> toBeAssignedIndexes = new HashSet<Integer>();
		for(int i = 0;  i < participants.length; i++) {
			toBeAssignedIndexes.add(i);
		}
		
		String[] assignments = new String[participants.length];
		
		int max = participants.length - 1;
		int min = 0;
		
		Random random = new Random();
		
		for(int i = 0; i < assignments.length; i++) {
			int selectedParticipantIndex = -1;
			
			
			do {
				min = findMin(toBeAssignedIndexes, participants.length);
				max = findMax(toBeAssignedIndexes, participants.length);
				
				selectedParticipantIndex = random.nextInt(max - min + 1) + min;
 				
				if(toBeAssignedIndexes.contains(selectedParticipantIndex) && (i != selectedParticipantIndex) && (toBeAssignedIndexes.size() != 2 || ((max != i + 1) || selectedParticipantIndex == max))) {
					assignments[i] = participants[selectedParticipantIndex];
					toBeAssignedIndexes.remove(selectedParticipantIndex);
					break;
				}
			} while((i == selectedParticipantIndex) || (!toBeAssignedIndexes.contains(selectedParticipantIndex) && !toBeAssignedIndexes.isEmpty()) || (toBeAssignedIndexes.size() == 2 && (max == i + 1)) );
		}
		
		return assignments;
	}
	
	private int findMin(Set<Integer> participantIndexes, int totalNumberOfAssignments) {
		int lowest = totalNumberOfAssignments;
		
		Iterator<Integer> participantIterator = participantIndexes.iterator();
		while(participantIterator.hasNext()) {
			Integer participantIndex = participantIterator.next();
			if(lowest > participantIndex) {
				lowest = participantIndex;
			}
		}
		return lowest;
	}
	
	private int findMax(Set<Integer> participantIndexes, int totalNumberOfAssignments) {
		int highest = -1;
		
		Iterator<Integer> participantIterator = participantIndexes.iterator();
		while(participantIterator.hasNext()) {
			Integer participantIndex = participantIterator.next();
			if(highest < participantIndex) {
				highest = participantIndex;
			}
		}
		return highest;
	}
	
}
