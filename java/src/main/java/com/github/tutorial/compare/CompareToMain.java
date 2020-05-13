package com.github.tutorial.compare;

public class CompareToMain {

	public static void main(String[] args) {
		new CompareToMain();
	}

//	if s1 > s2, it returns positive number  
//	if s1 < s2, it returns negative number  
//	if s1 == s2, it returns 0  
	CompareToMain() {
		String s1 = "hello";
		String s2 = "hello";
		String s3 = "meklo";
		String s4 = "hemlo";
		String s5 = "flag";
		System.out.println(s1.compareTo(s2)); // 0 because both are equal
		System.out.println(s1.compareTo(s3)); // -5 because "h" is 5 times lower than "m"
		System.out.println(s1.compareTo(s4)); // -1 because "l" is 1 times lower than "m"
		System.out.println(s1.compareTo(s5)); // 2 because "h" is 2 times greater than "f"

		// if compare string with blank or empty string, it returns length of the string
		String s6 = "hello";
		String s7 = "";
		String s8 = "me";
		System.out.println(s6.compareTo(s7)); // 5 because second string is empty, result would be positive
		System.out.println(s7.compareTo(s8)); // -2 because first string is empty, result would be negative
	}
}
