package com.bulutmf.sorting;

import java.util.Arrays;


/**
 * Sorting algorithms
 * 
 * @author fatih
 *
 */
public class Sorting {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// Create an array
		int length = 50;
		int[] unsortedArray = new int[length];
		for (int i=0;i < length;i++) {
			unsortedArray[i] = (int) (Math.random() * 100);
		}
		System.out.println(Arrays.toString(unsortedArray));
		
		// Sort the array using built-in sort method
		int[] sortedArray = Arrays.copyOf(unsortedArray, unsortedArray.length);
		Arrays.sort(sortedArray);// Sort using the built-in method
		
		// Check the correctness
		
		// Buble sort
		int[] resultOfSorting = bubleSort(Arrays.copyOf(unsortedArray, unsortedArray.length));
		System.out.println("Buble sort: " + (Arrays.equals(sortedArray, resultOfSorting)==true?"Passed":"Failed"));
		resultOfSorting = null;
		// Insertion sort 
		resultOfSorting = insertionSort(Arrays.copyOf(unsortedArray, unsortedArray.length));
		System.out.println("Insertion sort: " + (Arrays.equals(sortedArray, resultOfSorting)==true?"Passed":"Failed"));
		resultOfSorting = null;
	}

	/**
	 * Q: Sort a given array using buble sort.
	 * 
	 */
	private static int[] bubleSort(int[] elements) {
		if (elements.length == 0 || elements.length == 1)
			return elements;
		
		boolean swapped = true;
		
		while (swapped) {
			swapped = false;
			for (int  i=0;i < elements.length-1;i++) {
				if (elements[i] > elements[i+1]) {
					int temp = elements[i];
					elements[i] = elements[i+1];
					elements[i+1] = temp;
					swapped = true;
				}
			}
		}
		
		return elements;
	}
	
	/**
	 * Q: Sort a given array using insertion sort.
	 * 
	 */
	private static int[] insertionSort(int[] elements) {
		if (elements.length == 0 || elements.length == 1)
			return elements;
		
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
