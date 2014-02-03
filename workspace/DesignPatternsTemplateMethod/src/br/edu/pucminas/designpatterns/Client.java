package br.edu.pucminas.designpatterns;

import java.util.LinkedHashMap;
import java.util.Map;

public class Client {

	public static void main(String[] args) {
		Map<Integer, String> map = new LinkedHashMap<Integer, String>();
		map.put(2, "Sherl");
		map.put(1, "Coti");
		map.put(5, "Nala");
		map.put(3, "Linda");
		map.put(4, "Joseph");
		
		System.out.println("ReportMapPrinterStrategy:");
		MapPrinter printerStrategy = new ReportMapPrinterStrategy();
		printerStrategy.printMap(map);
		
		System.out.println("\nSortedMapPrinterStrategy using QuickSortTemplateMethod:");
		printerStrategy = new QuickSortTemplateMethod();
		printerStrategy.printMap(map);
		
		System.out.println("\nSortedMapPrinterStrategy using MergeSortTemplateMethod:");
		printerStrategy = new MergeSortTemplateMethod();
		printerStrategy.printMap(map);
		
		System.out.println("\nSortedMapPrinterStrategy using BubbleSortTemplateMethod:");
		printerStrategy = new BubbleSortTemplateMethod();
		printerStrategy.printMap(map);
		
	}

}
