package br.edu.pucminas.designpatterns;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class BubbleSortTemplateMethod extends SortedMapPrinterStrategy{
	@Override
	public List<Integer> sortSetAsList(Set<Integer> set) {
		Integer[] array = set.toArray(new Integer[]{});
		bubbleSort(array);
		return Arrays.asList(array);
	}
	
	public void bubbleSort(Integer[] array) {
	    int n = array.length;
	    
	    for (int pass=1; pass < n; pass++) { 
	        for (int i=0; i < n-pass; i++) {
	            if (array[i] > array[i+1]) {
	            	exchange(i, i+1, array);
	            }
	        }
	    }
	}

	private void exchange(Integer i, Integer j, Integer[] array) {
		Integer temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
}
