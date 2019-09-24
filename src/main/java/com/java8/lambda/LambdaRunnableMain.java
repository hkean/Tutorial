package com.java8.lambda;

/*
 * In both cases, notice that no parameter is passed and is returned. 
 * The Runnable lambda expression, which uses the block format, converts five lines of code into one statement.
 */
public class LambdaRunnableMain {
	public static void main(String[] args) {

		System.out.println("=== RunnableTest ===");

		// Anonymous Runnable
		Runnable r1 = new Runnable() {

			@Override
			public void run() {
				System.out.println("Hello world one!");
			}
		};

		// Lambda Runnable
		Runnable r2 = () -> System.out.println("Hello world two!");

		// Run em!
		r1.run();
		r2.run();

	}
}
