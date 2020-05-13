package com.github.tutorial.initialize;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.github.tutorial.model.Demo;

public class InitList {
	public static void main(String[] args) {
		// Arrays.asList: Returns a fixed-size list backed by the specified array.
		List<String> asList1 = Arrays.asList("a"); // mean that it can't add or remove 
//		asList1.remove("a"); // asList1.remove(0);
//		asList1.add("b");
		
		List<String> asList2 = new ArrayList<String>(Arrays.asList("a", "b"));

		System.out.println(asList1 + "" + asList2);

		asList2.stream()
		.filter(s -> s.contains("b"))
		.forEach(System.out::println);
		
		asList1.forEach(System.out::println);
		
		List<Demo> list3 = Arrays.asList(new Demo(1, "a", true), new Demo(2, "b",false));
		list3.forEach(System.out::println);
		System.out.println(Arrays.toString(list3.toArray()));
		
		List<Integer> list4 = Collections.unmodifiableList(Arrays.asList(1,2,3));
		System.out.println(list4);
		
		System.out.println(asList2.get(0));
		asList2.remove("a");
		System.out.println(asList2.size());
	}
}
