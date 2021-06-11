package com.github.tutorial.bitwise;

public class ChmodMain {

	public static void main(String[] args) {
		int var = 2;
		int mon = 1;
		int tue = 2;
		int wed = 4;

		// 00000001 1 00000001 1
		// 00000010 2 00000001 1
		// 00000001 0 00000001 1

		if ((var & mon) > 0) {
			System.out.println("Is Monday!");
		}
		if ((var & tue) > 0) {
			System.out.println("Is Tuesday!");
		}
		if ((var & wed) > 0) {
			System.out.println("Is Wednesday!");
		}

		System.out.println((1 | 2) + " = 3");
	}

}
