package com.github.tutorial.method.reference;

// https://docs.oracle.com/javase/tutorial/java/javaOO/methodreferences.html
public class MethodReferenceMain {

	public static void main(String[] args) {
		new MethodReferenceMain();
	}
	
	public MethodReferenceMain() {
		MainOperation toLowerCase = a -> a.toLowerCase();
//		MainOperation toUpperCase = a -> a.toUpperCase();
		MainOperation toUpperCase = String::toUpperCase;
		
		System.out.println(toLowerCase.operation("AAA"));
		System.out.println(operate("abc", toUpperCase));
	}
	
	public String operate(String input, MainOperation method) {
		return method.operation(input);
	}
	
	interface MainOperation {
		String operation(String a);
	}
}
