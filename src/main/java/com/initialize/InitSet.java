package com.initialize;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InitSet {

	public static void main(String[] args) {
//		Set<String> asSet1 = (Set<String>) Arrays.asList("a");
		Set<String> asSet2 = new HashSet<String>(Arrays.asList("a", "b"));
		// Set demonstration using Collections.addAll
		Set<String> asSet3 = Collections.<String>emptySet();
		Collections.addAll(asSet3 = new HashSet<String>(Arrays.asList("a", "b", "c")));
		// initializing set using Collections.unmodifiable set
		Set<String> asSet4 = Collections.unmodifiableSet(new HashSet<String>(Arrays.asList("a", "b", "c", "d")));

		Set<String> asSet5 = Stream.of("a", "b", "c", "d", "e").collect(Collectors.toSet());

//		Set<String> asSet6 = 
				Stream.of("a", "b", "c", "d", "e").collect(Collectors.toCollection(LinkedHashSet::new));
				
		System.out.println(//asSet1 + "" + 
				asSet2 + "" + asSet3 + "" + asSet4 + "" + asSet5);
		
		// get through iterate
		Iterator<String> i = asSet2.iterator();
		while (i.hasNext()) {
			System.out.print(i.next() + " ");
		}
		System.out.println();
		
		// get through loop
		for (String temp : asSet2) {
			System.out.print(temp + " ");
		}
		System.out.println();
		
		// get through toString toArray
		System.out.println(Arrays.toString(asSet2.toArray()));
		
		System.out.println(asSet2.size());
		asSet2.remove("a");
		System.out.println(asSet2.size());
		
		asSet3.forEach(System.out::print);
	}

}
