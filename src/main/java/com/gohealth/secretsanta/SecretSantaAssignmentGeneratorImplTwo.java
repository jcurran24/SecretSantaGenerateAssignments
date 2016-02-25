package com.gohealth.secretsanta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SecretSantaAssignmentGeneratorImplTwo implements SecretSantaAssignmentGenerator {

	@Override
	public String[] generateAssignments(String[] participants) {
		if(participants == null) {
			throw new IllegalArgumentException("Particpants array was null");
		}
		
		List<String> donor = toArrayList(participants);
	    
		String[] assignments = new String[participants.length];
		
		@SuppressWarnings("unchecked")
		List<String> receiver = (List<String>)(((ArrayList<String>)donor).clone());

	    for (int i = 0; i < donor.size(); i++) {
	        Collections.shuffle(receiver);
	        int target = 0;
	        
	        while(receiver.get(target).equals(donor.get(i)) && receiver.size() > 1){              
	            target++;
	        }
	        
	        assignments[i] = receiver.get(target);
	        if(receiver.size() == 1 && receiver.get(target).equals(donor.get(i))) {
	        	if(i > 0) {
	        		swap(assignments, i, i-1);
	        	}
	        }
	       
	        receiver.remove(receiver.get(target));
	        
	    }
	    return assignments;
	}
	
	private void swap(String[] array, int indexOne, int indexTwo) {
		String temp = array[indexTwo];
		array[indexTwo] = array[indexOne];
		array[indexOne] = temp;
	}

	public List<String> toArrayList(String[] array) {
		List<String> list = new ArrayList<String>();
		
		for(String elem : array) {
			list.add(elem);
		}
		return list;
	}
	
}
