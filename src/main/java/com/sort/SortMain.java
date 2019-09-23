package com.sort;

// http://www.java2novice.com/java-sorting-algorithms/
public class SortMain {
	public static void main(String[] args) {
		int[] input = { 4, 2, 9, 6, 23, 12, 34, 0, 1 };
		BubbleSort.bubble_srt(input);

		int[] arr1 = { 10, 34, 2, 56, 7, 67, 88, 42 };
		int[] arr2 = SelectionSort.doSelectionSort(arr1);
		for (int i : arr2) {
			System.out.print(i);
			System.out.print(", ");
		}

		int[] arr3 = { 10, 34, 2, 56, 7, 67, 88, 42 };
		int[] arr4 = InsertionSort.doInsertionSort(arr3);
		for (int i : arr4) {
			System.out.print(i);
			System.out.print(", ");
		}

		QuickSort sorter = new QuickSort();
		int[] input1 = { 24, 2, 45, 20, 56, 75, 2, 56, 99, 53, 12 };
		sorter.sort(input1);
		for (int i : input1) {
			System.out.print(i);
			System.out.print(" ");
		}

		int[] inputArr = { 45, 23, 11, 89, 77, 98, 4, 28, 65, 43 };
		MergeSort mms = new MergeSort();
		mms.sort(inputArr);
		for (int i : inputArr) {
			System.out.print(i);
			System.out.print(" ");
		}
	}
}
