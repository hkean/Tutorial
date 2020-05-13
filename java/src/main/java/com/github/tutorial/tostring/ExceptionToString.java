package com.github.tutorial.tostring;

import java.util.StringJoiner;


public class ExceptionToString {

	private Integer id;
	private Double sal; 
	
	@Override
	public String toString() {
		StringJoiner stringJoiner = new StringJoiner(", ", ExceptionToString.class.getSimpleName() + "{", "}");
		try {
			stringJoiner = stringJoiner.add("id=" + this.id).add("sal=" + this.sal);
//			stringJoiner.add("id=" + this.id).add("sal=" + this.sal);
			stringJoiner.toString();
		} catch (Exception e) {
			stringJoiner = stringJoiner.add("id=" + this.id);
//			stringJoiner.add("id=" + this.id);
		}

		return stringJoiner.toString();
	}
}
