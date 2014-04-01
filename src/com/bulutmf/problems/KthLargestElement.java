package com.bulutmf.problems;

public class KthLargestElement {

	/**
	 * Select the kth largest element from an array
	 * This solution is O(n^2) in worst case
	 * You can do it with O(nlogn) using sorting
	 * Or O(n) with Selection algorithm--medians of medians
	 */
	public static void main(String[] args) {
		
		int[] list = {1,10,3,6,5,2,7,8,9,4};
		System.out.println(select(list, 10, 0, list.length-1));
	}

	public static int select(int[] list, int k, int start, int end) {

	    if (start==end)
	        return list[start];
	    
	    // Partition the array around a pivot (1st element)
	    int i = partition(list, start, end);
	    int e = i - start + 1;
	    if (k <= e) {
	        return select(list, k, start, i);
	    } else {
	        return select(list, k-e, i+1, end);
	    }
	}

	private static int partition(int[] elements, int start, int end) {
		int pivot = elements[start];
		int i = start - 1;
		int j = end + 1;
		
		while(true) {
			do {
				j--;
			} while (elements[j] > pivot);
			
			do {
				i++;
			} while (elements[i] < pivot);
			
			if (i < j) {
				int temp = elements[i];
				elements[i] = elements[j];
				elements[j] = temp;
			} else {
				return j;
			}
		}
	}
}
