package com.github.tutorial.initialize;

import java.util.Arrays;

public class InitEnum {
	public static void main(String[] args) {
		EnumList e1 = EnumList.A;
		System.out.println(e1.toString());
		EnumList[] e2 = new EnumList[] { EnumList.A, EnumList.B };
		System.out.println(Arrays.toString(e2));
		EnumList[] e3 = new EnumList[3];
		Arrays.fill(e3, EnumList.A); // fill is used to fill all index with the same value
		Arrays.fill(e3, EnumList.B);
		Arrays.fill(e3, EnumList.C);
		System.out.println(Arrays.toString(e3));
	}
}
