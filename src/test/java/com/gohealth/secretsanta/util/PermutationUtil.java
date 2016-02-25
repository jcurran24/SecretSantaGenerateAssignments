package com.gohealth.secretsanta.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.google.common.collect.Collections2;


public class PermutationUtil {

	public static String[][] permutation(String []array) {
		List<String> list = new ArrayList<String>();
		
		for(String element : array) {
			list.add(element);
		}
		
		Collection<List<String>> permutatedList = Collections2.permutations(list);
		
		String[][] permutation = new String[permutatedList.size()][];
		
		int i = 0;
		for(List<String> possibility : permutatedList) {
			permutation[i] = new String[possibility.size()];
			int j = 0;
			for(String elem : possibility) {
				permutation[i][j] = elem;
				j++;
			}
			i++;
		}
		return permutation;
	}
}
