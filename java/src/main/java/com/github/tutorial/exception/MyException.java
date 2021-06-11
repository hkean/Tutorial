package com.github.tutorial.exception;

public class MyException extends RuntimeException {

	private static final long serialVersionUID = 6396230261734825188L;

	public MyException(String message) {
		super(message);
	}

}
