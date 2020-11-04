package com.github.tutorial.nul1;

// https://techvidvan.com/tutorials/java-null/

@SuppressWarnings({ "static-access", "unused" })
public class NullMain {

	// Any reference variable automatically has a null value as its default value
	private static Object obj;

	public static void main(String[] args) {
		System.out.println("Value of Object obj is: " + obj);

		// We can also type cast it to Integer
		Integer myInt1 = (Integer) null;

		// make use of instanceOf
		Double d1 = null;
		System.out.println(d1 instanceof Double);

		// can call a static method with reference variables with null values
		NullMain obj = null;
		obj.staticMethod();
//		obj.nonStaticMethod(); // this will cause error

		// can use these comparison operators (== and !=) with a null operator
		// but, cannot use it with other arithmetic or logical operators like (<) or (>)
		System.out.println(null == null);
		System.out.println(null != null);

		String result = null;
//		if (result.equalsIgnoreCase("Success")) { // this will cause error
		if (result != null && result.equalsIgnoreCase("Success")) { // so use != null
			System.out.println("Success");
		}
	}

	private static void staticMethod() {
		System.out.println("We can call the static method by a null reference\n");
	}

	private void nonStaticMethod() {
		System.out.print("We cannot call a non-static method by a null reference.");
	}
}
