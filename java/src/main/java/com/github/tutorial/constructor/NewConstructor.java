package com.github.tutorial.constructor;

public class NewConstructor {
	public String value = "";
	public Integer value2;

	public NewConstructor() {
		this.value = "default constructor";
	}

	public NewConstructor(String value) {
		this.value = value;
	}
	
	public NewConstructor(String value, Integer value2) {
		this.value = value;
		this.value2 = value2;
	}
}
