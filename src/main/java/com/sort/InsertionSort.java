package com.sort;

import com.sort.Util.SORT;

public class InsertionSort {
	public static int[] insertion(int[] input, SORT sort) {
		InsertionSort insert = new InsertionSort();
		if (sort.equals(SORT.ASC)) {
			return insert.doInsertionSort(input);
		} else if (SORT.DESC.equals(sort)) {
			return insert.doInsertionSortDesc(input);
		} else {
			return insert.dontKnowWhatSort(input);
		}
	}

	private int[] dontKnowWhatSort(int[] input) {
		for (int i = 1; i < input.length; i++) {
			for (int j = i; j > 0; j--) {
				System.out.print(j + " ");
				Util.printNumbers(input);
				if (input[j] < input[j - 1]) {
//					int temp = input[j];
//					input[j] = input[j - 1];
//					input[j - 1] = temp;
					Util.swapNumbers(j, j - 1, input);
				}
			}
		}
		return input;
	}

	// int[] input = {40, 30, 10, 70, 50, 20, 60};
	// key=30| j=0| 30, 40, 10, 70, 50, 20, 60 | 40 > 30, swap | [1] = 40
	// key=30| j=-1| [0] = 30
	// 2nd loop
	// key=10| j=1| 30, 40, 40, 70, 50, 20, 60 | 40 > 10, swap | [2] = 40
	// key=10| j=0| 10, 30, 40, 70, 50, 20, 60 | 30 > 10, swap | [1] = 30
	// key=10| j=-1| [0] = 10
	// 3rd loop
	// key=70| j=2| 10, 30, 40, 70, 50, 20, 60 | 40 > 70, no swap | [3] = 70
	// 4th loop
	// key=50| j=3| 10, 30, 40, 70, 70, 20, 60 | 70 > 50, swap | [4] = 70
	// key=50| j=2| 10, 30, 40, 50, 70, 20, 60 | 40 > 50, no swap | [3] = 50
	// 5th loop
	// key=20| j=4| 10, 30, 40, 50, 70, 70, 60 | 70 > 20, swap | [5] = 70
	// key=20| j=3| 10, 30, 40, 50, 50, 70, 60 | 50 > 20, swap | [4] = 50
	// key=20| j=2| 10, 30, 40, 40, 50, 70, 60 | 40 > 20, swap | [3] = 40
	// key=20| j=1| 10, 30, 30, 40, 50, 70, 60 | 30 > 20, swap | [2] = 30
	// key=20| j=0| 10, 20, 30, 40, 50, 70, 60 | 10 > 20, no swap | [1] = 20
	// 6th loop
	// key=60| j=5| 10, 20, 30, 40, 50, 70, 70 | 70 > 60, swap | [6] = 70
	// key=60| j=4| 10, 20, 30, 40, 50, 60, 70 | 50 > 60, no swap | [5] = 60
	private int[] doInsertionSort(int[] input) {
		for (int i = 1; i < input.length; i++) {
			int key = input[i];
			int j = i - 1;
			while (j >= 0 && input[j] > key) {
				input[j + 1] = input[j];
				System.out.print(j + " ");
				Util.printNumbers(input);
				j = j - 1;
			}
			input[j + 1] = key;
		}
		return input;
	}

	private int[] doInsertionSortDesc(int[] input) {
		for (int i = 1; i < input.length; i++) {
			int key = input[i];
			int j = i - 1;
			while (j >= 0 && input[j] < key) {
				input[j + 1] = input[j];
				j = j - 1;
			}
			input[j + 1] = key;
		}
		return input;
	}

	public static int[] insertionSort(int[] input, SORT sort) {
		InsertionSort insert = new InsertionSort();
		for (int i = 1; i < input.length; i++) {
			int key = input[i];
			int j = i - 1;
			j = insert.algo(key, j, input, sort);
			input[j + 1] = key;
		}
		return input;
	}

	private int algo(int key, int j, int[] input, SORT sort) {
		if (sort.equals(SORT.ASC)) {
			while (j >= 0 && input[j] > key) {
				input[j + 1] = input[j];
				System.out.print(j + " ");
				Util.printNumbers(input);
				j = j - 1;
			}
		} else if (sort.equals(SORT.DESC)) {
			while (j >= 0 && input[j] < key) {
				input[j + 1] = input[j];
				j = j - 1;
			}
		}
		return j;
	}
}
