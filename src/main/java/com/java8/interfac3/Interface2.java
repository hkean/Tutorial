package com.java8.interfac3;

public interface Interface2 {
	public void square(int a);

	default void show() {
		System.out.println("Default Method Executed");
	}

	default Integer getInt() {
		return 0;
	}
}
