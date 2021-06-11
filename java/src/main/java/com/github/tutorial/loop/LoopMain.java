package com.github.tutorial.loop;

import java.math.BigInteger;

// https://medium.com/javarevisited/subarray-vs-subsequence-do-you-know-the-difference-3de0a2c2df52

public class LoopMain {

	public static void main(String[] args) {
		new LoopMain();
	}

	public LoopMain() {
		int[] arr = { 1, 2, 3 };

		subArray(arr);
		subSequence(arr);
	}

	private void subArray(int arr[]) {
		// 'i' as starting index of subArray
		for (int i = 0; i < arr.length; i++) {
			// 'j' as ending index of subArray
			for (int j = i; j < arr.length; j++) {
				// print sub array from start to end
				printSubArray(arr, i, j);
			}
		}

	}

	private void printSubArray(int arr[], int start, int end) {
		for (int k = start; k <= end; k++) {
			System.out.print(" " + arr[k]);
		}
		System.out.println();
	}

	private void subSequence(int arr[]) {
		int n = arr.length;
		int seq = (int) Math.pow(2, n);

		for (int count = 1; count < seq; count++) {
			for (int i = 0; i < n; i++) {
				if (BigInteger.valueOf(count).testBit(i)) {
					System.out.print(" " + arr[i]);
				}
			}
			System.out.println();
		}
	}

}
