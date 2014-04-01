package com.bulutmf.problems;

public class PowerSet {

	/**
	 * Q: Print the power set of a numbers less than N (including)
	 */
	public static void main(String[] args) {
		
		
		int N = 4;
		int all = 1 << N;
		for (int i=1;i < all;i++) {
			for (int j=0;j < N;j++) {
				if ((i & (1 << j)) > 0)
					System.out.print("" + (j + 1) + ",");
			}
			
			System.out.println();
		}

	}

}
