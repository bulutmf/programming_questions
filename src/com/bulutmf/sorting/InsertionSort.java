package com.bulutmf.sorting;

import java.util.Arrays;


/**
 * Q: Sort a given array using insertion sort.
 * 
 * @author fatih
 *
 */
public class InsertionSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int length = 50;
		int[] unsortedArray = new int[length];
		for (int i=0;i < length;i++) {
			unsortedArray[i] = (int) (Math.random() * 100);
		}

		
		System.out.println(Arrays.toString(unsortedArray));
		// Sort the array using our method
		int[] sortedArray = insertionSort(Arrays.copyOf(unsortedArray, unsortedArray.length));
		//Check if two arrays are equal
		System.out.println(Arrays.equals(unsortedArray, sortedArray));
		// Print it
		System.out.println(Arrays.toString(sortedArray));
		
		// Now check the correctness using the built-in method
		Arrays.sort(unsortedArray);// Sort using the built-in method
		System.out.println(Arrays.equals(unsortedArray, sortedArray));
	}

	private static int[] insertionSort(int[] elements) {
		if (elements.length == 0 || elements.length == 1)
			return elements;
		else {
			for (int i=1;i < elements.length;i++) {
				int temp = elements[i];
				for (int j=i-1;j >= 0;j--) {
					if (temp < elements[j]) {
						elements[j+1] = elements[j];
						elements[j] = temp;
					} else
						break;
				}
			}
			return elements;
		}
	}
}
