package com.initialize;

import java.lang.reflect.Array;
import java.util.Arrays;

public class InitString {

	public static void main(String[] args) {
		String[] arr = new String[] { "A", "B", "C", "D", "E" };
		String[] arr2 = { "A", "B", "C", "D", "E" };
		String[] arr3 = new String[5];
		Arrays.fill(arr3, "A");
		Arrays.fill(arr3, 1, 3, "B");
		Arrays.setAll(arr3, i -> "A");
		String[] arr4 = (String[]) Array.newInstance(String.class, 5);

		System.out.println(arr + "" + arr2 + "" + arr3 + "" + arr4);

		// get through toString
		System.out.println(Arrays.toString(arr));
	}
}
