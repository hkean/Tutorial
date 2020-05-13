package com.github.tutorial.interfac3;

public interface Interface1 {
	Integer i = 0;

	// abstract method
	public void square(int a);

	// static method
	static void show() {
		System.out.println("Static Method Executed");
	}

//	Compile error: Abstract methods do not specify a body
//	void show1() {}

	static Integer getInt() {
		return i;
	}

//	static void setInt(Integer in) {
//		i = in; // The final field Interface1.i cannot be assigned
//	}
}
