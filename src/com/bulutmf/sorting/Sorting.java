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
		
		// Merge sort 
		resultOfSorting = mergeSort(Arrays.copyOf(unsortedArray, unsortedArray.length), 0, unsortedArray.length-1);
		System.out.println("Merge sort: " + (Arrays.equals(sortedArray, resultOfSorting)==true?"Passed":"Failed"));
		resultOfSorting = null;
	}

	
	/**
	 * Q: Sort a given array using buble sort.
	 * 
	 */
	public static int[] mergeSort(int[] elements, int start, int end) {
		if (start == end)
			return elements;
		
		int middle = (end + start) / 2;
		mergeSort(elements, start, middle);
		mergeSort(elements, middle + 1, end);
		merge(elements, start, middle, end);
		
		return elements;
	}
	
	private static void merge(int[] elements, int start, int middle, int end) {
		int[] newArray = new int[end-start+1];
		int counter = 0;
		int i = start;
		int j = middle + 1;
		
		while (i <= middle || j <= end) {
			if (i <= middle && j > end) {// Exhaust all the elements until the middle one
				while (i <= middle) {
					newArray[counter] = elements[i];
					i++;
					counter++;
				}
			} else if (i > middle && j <= end) {// Exhaust all the elements until the end
				while(j <= end) {
					newArray[counter] = elements[j];
					j++;
					counter++;
				}
			} else {
				if (elements[i] > elements[j]) {
					newArray[counter] = elements[j];
					j++;
					counter++;
				} else {
					newArray[counter] = elements[i];
					i++;
					counter++;
				}
			}
		}
		
		// Copy elements to the original array
		for(i=start; i <= end;i++) {
			elements[i] = newArray[i-start];
		}
	}
	
	/**
	 * Q: Sort a given array using buble sort.
	 * 
	 */
	public static int[] bubleSort(int[] elements) {
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
	public static int[] insertionSort(int[] elements) {
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
