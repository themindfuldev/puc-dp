package br.edu.pucminas.designpatterns;

import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class SortedMapPrinterStrategy implements MapPrinter {
	
	public void printMap(Map<Integer, String> map) {
		List<Integer> orderedList = sortSetAsList(map.keySet()); 
		
		for (Integer key: orderedList) {
			System.out.println(key + ": " + map.get(key));
		}
	}
	
	public abstract List<Integer> sortSetAsList(Set<Integer> set);
	
}
