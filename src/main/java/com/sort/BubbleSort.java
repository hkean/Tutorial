package com.sort;

import com.sort.Util.SORT;

public class BubbleSort {
	public static int[] bubble(int[] array, SORT sort) {
		BubbleSort bubble = new BubbleSort();
		if (sort.equals(SORT.ASC)) {
			return bubble.bubble_srt(array);
		} else if (SORT.DESC.equals(sort)) {
			return bubble.bubble_srt_desc(array);
		} else {
			return null;
		}
	}

	// int[] input = {40, 30, 10, 70, 50, 20, 60};
	// 1. 30, 40, 10, 70, 50, 20, 60 | 40 > 30, swap
	// 2. 30, 10, 40, 70, 50, 20, 60 | 10 > 40, no swap
	// 3. 30, 10, 40, 70, 50, 20, 60 | 40 > 70, no swap
	// 4. 30, 10, 40, 50, 70, 20, 60 | 70 > 50, swap
	// 5. 30, 10, 40, 50, 20, 70, 60 | 70 > 20, swap
	// 6. 30, 10, 40, 50, 20, 70, 60 | 70 > 60, swap
	// 7. 30, 10, 40, 50, 20, 60, 70 | end 1st loop, next loop max-1, 70 is last
	private int[] bubble_srt(int[] array) {
		int n = array.length;
		int k;
		for (int m = n; m >= 0; m--) {
//			for (int i = 0; i < n - 1; i++) {
			for (int i = 0; i < m - 1; i++) {
				Util.printNumbers(array);
				k = i + 1;
				if (array[i] > array[k]) {
					Util.swapNumbers(i, k, array);
				}
			}
			System.out.println("first loop end: " + m + "\n");
		}
		return array;
	}

	private int[] bubble_srt_desc(int[] array) {
		int count = 0;
		for (int m = array.length; m >= 0; m--) {
			for (int i = 0; i < m - 1; i++) {
				count++;
				if (array[i] < array[i + 1]) {
					Util.swapNumbers(i, i + 1, array);
				}
			}
		}
		System.out.println(count);
		return array;
	}
}
