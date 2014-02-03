package br.edu.pucminas.designpatterns;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * Comentario extraido do metodo Arrays.sort()
 * 
 * Sorts the specified array of ints into ascending numerical order. 
 * The sorting algorithm is a tuned quicksort, adapted from Jon L. Bentley and M. Douglas McIlroy's 
 * "Engineering a Sort Function", Software-Practice and Experience, Vol. 23(11) P. 1249-1265 
 * (November 1993). 
 * This algorithm offers n*log(n) performance on many data sets that cause other quicksorts to 
 * degrade to quadratic performance.
 * 
 * @author samuel
 *
 */
public class QuickSortTemplateMethod extends SortedMapPrinterStrategy {
	
	@Override
	public List<Integer> sortSetAsList(Set<Integer> set) {
		Integer[] array = set.toArray(new Integer[]{});
		Arrays.sort(array);
		return Arrays.asList(array);
	}
	
}
