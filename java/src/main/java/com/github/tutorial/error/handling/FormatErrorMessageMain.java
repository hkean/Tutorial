package com.github.tutorial.error.handling;

import java.text.MessageFormat;

public class FormatErrorMessageMain {

	public static void main(String[] args) {
		new FormatErrorMessageMain();
	}

	public FormatErrorMessageMain() {
		collect("", "Say something", "abc");
//		collect("", new String[] { "isSingleMother", "what" });
	}
	
	public void collect(String errorCode, Object... objects) {
		collect(errorCode, null, objects);
	}
	
	public void collect(String errorCode, Throwable cause, Object... params) {
		String formattedMessage = formatMessage("Invalid Clinical data. {0}, {1} may not be null.", params);
		System.out.println(formattedMessage);
	}

	protected String formatMessage(String message, Object... params) {
		return new MessageFormat(message).format(params);
	}
}
