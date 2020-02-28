package com.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.google.common.base.Predicates;
import com.java8.function.FunctionMain;
import com.model.Demo;

public class StreamMain {

	List<String> listString = Arrays.asList("a", "b", "c");
	List<Demo> listDemo = Arrays.asList(new Demo(1, "a", true), 
										new Demo(2, "b", false), 
										new Demo(3, "c", false));

	public static void main(String[] args) {
		new StreamMain();
	}

	StreamMain() {

	}

	// before map: [a,b,c]
	// after map: [A,B,C]
	void testMap() {
		List<String> result = listString.stream()
										.map(String::toUpperCase)
										.collect(Collectors.toList());
		System.out.println(result);
	}

	// before flatMap: [[a],[b],[c]]
	// after flatMap: [a,b,c]
	void testFlatMap() {
		listString.stream()
			.flatMap(str -> Stream.of(str))
			.forEach(System.out::println);
	}

	// initial: [[Demo],[Demo],[Demo]]
	// flatMap: [Demo,Demo,Demo]
	// map: [name, name, name]
	void testFunction() {
		Stream.of(listDemo)
			.flatMap(in -> in.stream())
			.map(FunctionMain.DEMO_TO_NAME_FUNC)
			.filter(Predicates.notNull())
			.collect(Collectors.toList());
	}

	// stream: [Demo,Demo,Demo]
	// map: [name, name, name]
	void testFunction2() {
		List<String> result = listDemo.stream()
										.map(FunctionMain.DEMO_TO_NAME_FUNC)
										.collect(Collectors.toList());
		result.forEach(System.out::println);
	}

}
