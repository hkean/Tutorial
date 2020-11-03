package com.github.tutorial.inner.clazz;

//outer class
public class MethodOuterClass {
	void outerMethod() {
//		final int var = 60; // declaring variable as final
		int var = 60; // declaring variable as final
		System.out.println("Inside outer method");
		// inner class inside a method of outer class
		class MethodInnerClass {
			void innerMethod() {
				System.out.println("Inside inner method");
				// suppose can only access if final, but still working
				// not sure why though?
				System.out.println("Value of variable is: " + var);
			}
		} // inner class ends here

		// initializing object of inner class inside the method
		MethodInnerClass innerObj = new MethodInnerClass();
		innerObj.innerMethod();
	} // method ends here

	public static void main(String[] args) {
		MethodOuterClass outerObj = new MethodOuterClass();
		outerObj.outerMethod();
	}
}
