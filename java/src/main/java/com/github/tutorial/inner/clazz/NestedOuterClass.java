package com.github.tutorial.inner.clazz;

public class NestedOuterClass {
	// private variable of the outer class
	private int value = 30;

	// inner class
	class NestedInnerClass {
		// public variable of the inner class
		public int getValue() {
			System.out.println("This is the getValue method of the inner class:");
			return value;
		}
	} // inner class end here

	public static void main(String args[]) {
		// Creating object of outer class
		NestedOuterClass outer = new NestedOuterClass();

		// Creating object of inner class
		NestedOuterClass.NestedInnerClass inner = outer.new NestedInnerClass();
		System.out.println("Value:" + inner.getValue());
	}
}
