package com.errorhandling;

import java.util.HashSet;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

class abc extends Exception {
	private static final long serialVersionUID = -7595615251392907376L;

	String s;

	abc(String s) {
		super(s);
	}
}

public class UserDefinedException {
	public static void main(String[] args) throws Exception {
		int s = 0;
		if (s == 1) {
			throw new abc("custom made exception");
		} else if (s == 0) {
			throw new ArithmeticException("custom made exception");
		} else if (s == -1) {
			throw new ConstraintViolationException(new HashSet<ConstraintViolation<FormatErrorMessageMain>>());
		}
	}
}
