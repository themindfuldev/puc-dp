package br.edu.pucminas.designpatterns;

import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Set;

/**
 * Comentario extraido do metodo Collections.sort()
 * 
 * Sorts the specified list into ascending order, according to the natural ordering of its elements. 
 * All elements in the list must implement the Comparable interface. Furthermore, all elements in the 
 * list must be mutually comparable (that is, e1.compareTo(e2) must not throw a ClassCastException 
 * for any elements e1 and e2 in the list).
 * This sort is guaranteed to be stable: equal elements will not be reordered as a result of the sort.
 * The specified list must be modifiable, but need not be resizable.
 * The sorting algorithm is a modified mergesort (in which the merge is omitted if the highest element 
 * in the low sublist is less than the lowest element in the high sublist). This algorithm offers 
 * guaranteed n log(n) performance. This implementation dumps the specified list into an array, sorts 
 * the array, and iterates over the list resetting each element from the corresponding position in the 
 * array. This avoids the n2 log(n) performance that would result from attempting to sort a linked list 
 * in place.
 * 
 * @author samuel
 *
 */
public class MergeSortTemplateMethod extends SortedMapPrinterStrategy {

	@Override
	public List<Integer> sortSetAsList(Set<Integer> set) {
		Enumeration<Integer> enumeration = Collections.enumeration(set);
		List<Integer> list = Collections.list(enumeration);
		Collections.sort(list);
		return list;
	}

}
