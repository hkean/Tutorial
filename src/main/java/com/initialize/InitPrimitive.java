package com.initialize;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class InitPrimitive {

	static int i;

	public static void main(String[] args) {
		i = i + 1;

//		int innerInt;
//		
//		// local variable a may not have been initialized
//		innerInt = innerInt + 1; // compilation error 

		new InitPrimitive();
	}

	public InitPrimitive() {
		Integer();
		String();
	}

	void Integer() {
		int[] a = { 1, 2, 3 };
		System.out.println(Arrays.toString(a));
	}

	void String() {
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
	
	void Dat3() {
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		
		Date date = new Date();
		System.out.println(simpleDateFormat.format(date));
		
		Calendar cal = Calendar.getInstance();
		cal.set(2002, Calendar.JULY, 21, 12, 00, 01);
		Date date2 = cal.getTime();
		System.out.println(simpleDateFormat.format(date2));	
	}
}
