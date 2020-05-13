package com.github.tutorial.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

// https://www.baeldung.com/java-stream-sum

@SuppressWarnings("unused")
public class StreamSum {

	static long aVeryBigSum(long[] ar) {
		// get sum
		return LongStream.of(ar).sum();
	}

	static int mapSum(Map<String, Integer> integers) {
		int sol1 = integers.values().stream().mapToInt(i -> i.intValue()).sum();
		int sol2 = integers.values().stream().mapToInt(Integer::intValue).sum();
		int sol3 = integers.values().stream().mapToInt(Integer::valueOf).sum();

		return sol2;
	}

	void reduce() {
		List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
		Integer sum1 = integers.stream().reduce(0, (a, b) -> a + b);

		Integer sum2 = integers.stream().reduce(0, Integer::sum);

		Integer sum3 = integers.stream().reduce(0, ArithmeticUtils::add);
	}

	void collect() {
		List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
		Integer sum = integers.stream().collect(Collectors.summingInt(Integer::intValue));
	}
}

class ArithmeticUtils {

	public static int add(int a, int b) {
		return a + b;
	}
}