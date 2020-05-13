package com.github.tutorial.interfac3;

// https://www.geeksforgeeks.org/default-methods-java/

public class Java8InterfaceMain implements Interface1, Interface2 {
	// , Interface3 { // Compile error: Duplicate default methods

	// Implementation of square abstract method
	public void square(int a) {
		System.out.println(a * a);
	}

	public static void main(String args[]) {
		Java8InterfaceMain d = new Java8InterfaceMain();
		d.square(4);

		// Static method executed
		Interface1.show();

//		Interface1.setInt(1);
		System.out.println(Interface1.getInt());

		d.show();
		System.out.println(d.getInt());
	}
}
