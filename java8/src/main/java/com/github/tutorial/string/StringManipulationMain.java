package com.github.tutorial.string;

import java.util.Objects;

public class StringManipulationMain {

	public static void main(String[] args) {
		new StringManipulationMain();
	}

	public StringManipulationMain() {
		String[] a = new String[] { "a" };
		joinManipulate();
		System.out.println(strJoin(",", a));
	}

	private void joinManipulate() {
		String a = String.join("_", "1", "Token", "Rec");
		System.out.println(a);
	}

	private String strJoin(String deli, String... ele) {
		Objects.requireNonNull(ele);
		StringBuilder result = null;

		for (String s : ele) {
			if (null == result) {
				result = new StringBuilder(s);
			} else {
				result.append(deli).append(s);
			}
		}
		return (null == result) ? null : result.toString();
	}

}
