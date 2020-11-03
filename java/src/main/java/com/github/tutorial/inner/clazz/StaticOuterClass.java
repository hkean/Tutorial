package com.github.tutorial.inner.clazz;

public class StaticOuterClass {
	static class StaticInnerNested {
		public void myMethod() {
			System.out.println("This is a static nested class");
		}

		public static void main(String args[]) {
			// Accessing the static nested class without initializing the object
			// of Outer class
			StaticOuterClass.StaticInnerNested nested = new StaticOuterClass.StaticInnerNested();
			nested.myMethod();
		}
	}
}