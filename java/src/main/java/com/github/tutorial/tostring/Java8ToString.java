package com.github.tutorial.tostring;

import java.util.StringJoiner;

public class Java8ToString {
	private Integer id;
	private String desc;

	@Override
	public String toString() {
		return new StringJoiner(", ", Java8ToString.class.getSimpleName() + "{", "}").add("id=" + id)
				.add("desc=" + desc).toString();
	}
}
