package com.github.tutorial.stream;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

// https://www.baeldung.com/java-8-streams
// https://github.com/eugenp/tutorials/tree/master/java-streams

@SuppressWarnings("unused")
public class StreamBaeldung {

	public static void main(String[] args) {
		new StreamBaeldung();
	}

	StreamBaeldung() {

	}

	// to create an empty stream 
	void emptyStream() {
		Stream<String> streamEmpty = Stream.empty();
	}

	// to create any type of Collection (Collection, List, Set):
	void streamOfCollection() {
		Collection<String> collection = Arrays.asList("a", "b", "c");
		Stream<String> streamOfCollection = collection.stream();
	}

	void streamOfArray() {
		Stream<String> streamOfArray = Stream.of("a", "b", "c");

		// create from existing array
		String[] arr = new String[] { "a", "b", "c" };
		Stream<String> streamOfArrayFull = Arrays.stream(arr);
		Stream<String> streamOfArrayPart = Arrays.stream(arr, 1, 3); // range
	}

	void streamBuilder() {
		Stream<String> streamBuilder = Stream.<String>builder().add("a").add("b").add("c").build();
	}

	// if didn't specify limit, it will work until it hit memory limit
	void streamGenerate() {
		Stream<String> streamGenerated =
				  Stream.generate(() -> "element").limit(10);
	}
	
	// first element is first parameter of iterate = 40
	// subsequent following the first param + 2 = 42
	void streamIterate() {
		Stream<Integer> streamIterated = Stream.iterate(40, n -> n + 2).limit(20);
	}

//	void streamPrimitive() {
//		IntStream intStream = IntStream.range(1, 3);
//		LongStream longStream = LongStream.rangeClosed(1, 3);
//	}

//	void streamOfString () {
//		IntStream streamOfChars = "abc".chars();
//		
//		Stream<String> streamOfString =
//				Pattern.compile(", ").splitAsStream("a, b, c");
//	}

	void streamOfFile() {
		Stream<String> streamOfStrings = null;
		Stream<String> streamWithCharset;
		try {
			Path path = Paths.get("C:\\file.txt");
			streamOfStrings = Files.lines(path);
			streamWithCharset = Files.lines(path, Charset.forName("UTF-8"));
		} catch (IOException e) {
			e.printStackTrace();
		}
//		finally {
//			streamOfStrings.close();
//		}
	}
	
	// a chain of stream source, intermediate operations, and a terminal operation
	void streamPipeline() {
		Stream<String> onceModifiedStream =
				  Stream.of("abcd", "bbcd", "cbcd").skip(1);
		
		List<String> list = Arrays.asList("abc1", "abc2", "abc3");
		long size = list.stream().skip(1)
		  .map(element -> element.substring(0, 3)).sorted().count();
	}
	
	void lazyInvocation() {
		
	}
}
