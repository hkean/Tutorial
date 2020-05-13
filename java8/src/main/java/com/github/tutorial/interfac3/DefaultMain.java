package com.github.tutorial.interfac3;

public class DefaultMain implements Interface2, Interface3 {
	// Implementation of square abstract method
	public void square(int a) {
		System.out.println(a * a);
	}

	// Overriding default show method
	public void show() {
		// use super keyword to call the show
		// method of Interface2 interface
		Interface2.super.show();

		// use super keyword to call the show
		// method of Interface3 interface
		Interface3.super.show();
	}

	public static void main(String args[]) {
		DefaultMain d = new DefaultMain();
		d.show();
	}
}
