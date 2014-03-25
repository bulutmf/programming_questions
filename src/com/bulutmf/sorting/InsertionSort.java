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
		
		int length = 100;
		int[] elements = new int[length];
		for (int i=0;i < length;i++) {
			elements[i] = (int) (Math.random() * 100);
		}

		System.out.println(Arrays.toString(elements));
		insertionSort(elements);
		System.out.println(Arrays.toString(elements));
	}

	private static void insertionSort(int[] elements) {
		if (elements.length == 0 || elements.length == 1)
			return;
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
		}
	}
}
