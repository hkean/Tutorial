package com.github.tutorial.generic;

public class GenericMain {

	public static void main(String[] args) {
		new GenericMain();

	}

	GenericMain() {
		// Create arrays of Integer, Double and Character
		Integer[] intArray = { 1, 2, 3, 4, 5 };
		Double[] doubleArray = { 1.1, 2.2, 3.3, 4.4 };
		Character[] charArray = { 'H', 'E', 'L', 'L', 'O' };
		String[] strArray = { "W", "O", "R", "L", "D" };

		GenericMethod.printGenericArray(intArray);
		GenericMethod.printGenericArray(doubleArray);
		GenericMethod.printGenericArray(charArray);
		GenericMethod.printStringArray(strArray);

		System.out.printf("Max of %d, %d and %d is %d\n\n", 3, 4, 5, GenericMethod.maximum(3, 4, 5));

		System.out.printf("Max of %.1f,%.1f and %.1f is %.1f\n\n", 6.6, 8.8, 7.7, GenericMethod.maximum(6.6, 8.8, 7.7));

		System.out.printf("Max of %s, %s and %s is %s\n", "pear", "apple", "orange",
				GenericMethod.maximum("pear", "apple", "orange"));

		GenericClass<Integer> integerBox = new GenericClass<Integer>();
		GenericClass<String> stringBox = new GenericClass<String>();

		integerBox.add(new Integer(10));
		stringBox.add(new String("Hello World"));

		System.out.printf("Integer Value :%d\n\n", integerBox.get());
		System.out.printf("String Value :%s\n", stringBox.get());
	}
}
