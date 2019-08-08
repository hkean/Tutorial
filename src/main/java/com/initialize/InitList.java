package com.initialize;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InitList {
	public static void main(String[] args) {
		List<String> asList1 = Arrays.asList("a");
		List<String> asList2 = new ArrayList<String>(Arrays.asList("a", "b"));

		System.out.println(asList1 + "" + asList2);

		asList2.stream()
		.filter(s -> s.contains("b"))
		.forEach(System.out::println);
	}
}
