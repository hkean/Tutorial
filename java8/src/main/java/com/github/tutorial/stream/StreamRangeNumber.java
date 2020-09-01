package com.github.tutorial.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

// https://farenda.com/java/java-8-range-of-numbers/

public class StreamRangeNumber {
	public static void main(String[] args) {
		new StreamRangeNumber();
	}

	public StreamRangeNumber() {
		int max = 5;

		System.out.println(intStreamRangeClosed(0, max));

		System.out.println(streamIterateRange(1, 1, max));
	}

	void forEachLoop(int max) {

	}

	void intStream(int from, int limit) {
		List<Integer> range = IntStream.range(from, limit).boxed().collect(Collectors.toList());
		System.out.println(range);
	}

	public List<Integer> intStreamRangeClosed(int from, int limit) {
		return IntStream.rangeClosed(from, limit).boxed().collect(Collectors.toList());

	}

	void intStreamIterateRange(int from, int step, int limit) {
		IntStream.iterate(from, i -> i + step) // next int
				.limit(limit / step) // only numbers in range
				.boxed().collect(Collectors.toList());
	}

	public List<Integer> streamIterateRange(int from, int step, int limit) {
		return Stream.iterate(from, n -> n + step).limit(limit).collect(Collectors.toList());
	}
}
