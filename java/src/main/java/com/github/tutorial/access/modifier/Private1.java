package com.github.tutorial.access.modifier;

public class Private1 {
	private String strPrivate = "private";

	private Private1() {
		// if without this, then it will prompt never used locally
		print();
	}

	private void print() {
		System.out.println(strPrivate);
	}

	class Private2 {
		private Private2() {
			Private1 pri = new Private1();
			pri.print();
		}
	}

}

class Private3 {
	private Private3() {
//		Private1 pri = new Private1(); // private constructor not visible
	}
}