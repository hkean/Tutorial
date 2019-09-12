package com.initialize;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.model.Demo;

public class InitList {
	public static void main(String[] args) {
		List<String> asList1 = Arrays.asList("a");
		List<String> asList2 = new ArrayList<String>(Arrays.asList("a", "b"));

		System.out.println(asList1 + "" + asList2);

		asList2.stream()
		.filter(s -> s.contains("b"))
		.forEach(System.out::println);
		
		asList1.forEach(System.out::println);
		
		List<Demo> list3 = Arrays.asList(new Demo(1, "a", true), new Demo(2, "b",false));
		list3.forEach(System.out::println);
		System.out.println(Arrays.toString(list3.toArray()));
	}
}
