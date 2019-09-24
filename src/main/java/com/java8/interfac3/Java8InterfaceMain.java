package com.java8.interfac3;

// https://www.geeksforgeeks.org/default-methods-java/

public class Java8InterfaceMain implements Interface1 {

	// Implementation of square abstract method
	public void square(int a) {
		System.out.println(a * a);
	}

	public static void main(String args[]) {
		Java8InterfaceMain d = new Java8InterfaceMain();
		d.square(4);

		// Static method executed
		Interface1.show();
	}
}
