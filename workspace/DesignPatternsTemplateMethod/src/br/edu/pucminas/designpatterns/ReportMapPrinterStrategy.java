package br.edu.pucminas.designpatterns;

import java.util.Arrays;
import java.util.Map;

public class ReportMapPrinterStrategy implements MapPrinter {
	
	public void printMap(Map<Integer, String> map) {
		for (Integer key: map.keySet()) {
			System.out.print("map[" + key + "] = " + map.get(key));
			System.out.print("\t\tHashcode = " + map.get(key).hashCode());
			System.out.print("\tClass = " + map.get(key).getClass());
			System.out.println("\tBytes = " + Arrays.toString(map.get(key).getBytes()));
		}
	}
	
}
