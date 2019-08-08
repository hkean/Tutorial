package com.initialize;

import java.util.AbstractMap;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InitMap {

	public static void main(String[] args) {
		Map<String, String> m1 = new HashMap<>();
		m1.put("1", "Intro to Map");
		m1.put("2", "Some article");

//		Map<String, String> m2 = 
		Collections.singletonMap("username1", "password1");
//		m2.put("", ""); // throw java.lang.UnsupportedOperationException

		// use a Stream of a two-dimensional String array and collect them into a map
		Map<String, String> m3 = Stream.of(new String[][] { 
			{ "Hello", "World" }, 
			{ "John", "Doe" }, 
		}).collect(Collectors.toMap(data -> data[0], data -> data[1]));
		m3.put("3", "3");
		
		// more generic
		Map<String, Integer> m4 = Stream.of(new Object[][] { 
		    { "data1", 1 }, 
		    { "data2", 2 }, 
		}).collect(Collectors.toMap(data -> (String) data[0], data -> (Integer) data[1]));
		m4.put("3", 3);
		
		// SimpleEntry implementation of the Entry interface
		Map<String, Integer> m5 = Stream.of(
				new AbstractMap.SimpleEntry<>("idea", 1), 
				new AbstractMap.SimpleEntry<>("mobile", 2))
		.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
		m5.put("3", 3);
		
		// using SimpleImmutableEntry 
		Map<String, Integer> m6 = Stream.of(
				new AbstractMap.SimpleImmutableEntry<>("idea", 1),    
				new AbstractMap.SimpleImmutableEntry<>("mobile", 2))
		.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
		m6.put("3", 3);

		System.out.println(m6.get("3"));
		
		m6.forEach((k, v) -> System.out.println(k + ":" + v));
	}
}
