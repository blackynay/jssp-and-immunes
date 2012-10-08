package aia_g_jssp;

import java.util.Arrays;
import java.util.Comparator;

public class ArrayIndexComparator implements Comparator<Integer> {
	/*
	 * private final String[] array;
	 * 
	 * public ArrayIndexComparator(String[] array) { this.array = array; }
	 */

	private final Integer[] array;

	public ArrayIndexComparator(Integer[] array) {
		this.array = array;
	}

	public Integer[] createIndexArray() {
		Integer[] indexes = new Integer[array.length];
		for (int i = 0; i < array.length; i++) {
			indexes[i] = i; // Autoboxing
		}
		return indexes;
	}

	@Override
	public int compare(Integer index1, Integer index2) {
		// Autounbox from Integer to int to use as array indexes
		return array[index1].compareTo(array[index2]);
	}

	public static void main(String[] args) {
		// String[] countries = { "France", "Spain","France", "France",
		// "Italy","spain", "Italy", };
		Integer[] countries = { 6, 5, 2, 7, 2, 6, 7, 9 };
		ArrayIndexComparator comparator = new ArrayIndexComparator(countries);
		Integer[] indexes = comparator.createIndexArray();
		/*
		 * for (Integer i = 0; i < indexes.length; i++) {
		 * System.out.print(indexes[i]); } System.out.println();
		 * Arrays.sort(indexes, comparator); for (Integer i = 0; i <
		 * indexes.length; i++) { System.out.print(indexes[i]); }
		 * System.out.println();
		 */
	}
}
