package com.oracle.blogs;

// https://blogs.oracle.com/javamagazine/quiz-yourself-creating-and-invoking-overloaded-methods-intermediate

public class OverloadedMethod {
	static void log(Object o) {
		/* code */ } // line n1

	static void log(Long[] lwa) {
		/* code */ } // line n2

	public static void main(String[] args) {
		log(new Integer[] {});
		long[] arr = null;
		log(arr);
		log(null);
	}
}

//Assuming any changes are done independently, which two statements are true? Choose two.
//A. The code compiles successfully.	
//B. The code compiles if you add a new method: static void log(Integer[] iwa) { /* code */ }	
//C. The code compiles if you comment out line n1.	
//D. The code compiles if you comment out line n2.
