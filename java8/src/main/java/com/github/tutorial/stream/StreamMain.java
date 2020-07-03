package com.github.tutorial.stream;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.github.tutorial.function.FunctionMain;
import com.github.tutorial.model.Demo;
import com.github.tutorial.model.Person;
import com.google.common.base.Predicates;

public class StreamMain {

	Demo a = new Demo(1, "a", true);
	Demo b = new Demo(2, "b", false);
	Demo c = new Demo(3, "c", false);
	List<String> listString = Arrays.asList("a", "b", "c");
	List<Demo> listDemo = Arrays.asList(a, b, c);
	List<Demo> listDemo2 = Arrays.asList(b);

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

	// "convert" into another object using map
	void testObjectToAnotherObject() {
		List<Person> result = listDemo.stream()
			.map(tmp -> {
				Person p = new Person();
				p.setName(tmp.getName());
				return p;
			}).collect(Collectors.toList());
		result.forEach(System.out::println);
		
		List<Integer> result2 = listDemo.stream()
				.map(tmp -> { return tmp.getId(); })
				.collect(Collectors.toList());
		result2.forEach(System.out::println);
	}
	
	// filter specific logic
	void testFilter() {
		List<Demo> result = listDemo.stream()
			.filter(tmp -> 1 == tmp.getId() && "a" == tmp.getName())
			.collect(Collectors.toList());
		result.forEach(System.out::println);
		
		Collection<Demo> result2 = listDemo.stream()
				.filter(tmp -> !listDemo2.contains(tmp))
				.collect(Collectors.toList());
		result2.forEach(System.out::println);
			
		// use predicate
		Predicate<Demo> predicate = input -> !listDemo2.stream().anyMatch(tmp -> input.equals(tmp));
		Collection<Demo> result3 = listDemo.stream()
				.filter(predicate)
				.collect(Collectors.toList());
		result3.forEach(System.out::println);
	}
	
}
