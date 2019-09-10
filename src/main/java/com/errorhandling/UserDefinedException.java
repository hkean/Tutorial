package com.errorhandling;

class abc extends Exception {
	private static final long serialVersionUID = -7595615251392907376L;

	String s;

	abc(String s) {
		super(s);
	}
}

public class UserDefinedException {
	public static void main(String[] args) throws abc, ArithmeticException {
		int s = 0;
		if (s == 0) {
			throw new abc("custom made exception");
		} else if (s == 0) {
			throw new ArithmeticException("custom made exception");
		}
	}
}
